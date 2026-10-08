package com.apklachy.app.ui.historial

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.apklachy.app.R
import com.apklachy.app.data.Reparacion
import com.apklachy.app.data.TipoTrabajo
import com.apklachy.app.ui.AppViewModel
import com.apklachy.app.ui.componentes.FormularioReparacion
import com.apklachy.app.util.Formato
import com.apklachy.app.util.Marcas
import java.util.Locale

@Composable
fun HistorialScreen(
    viewModel: AppViewModel,
    modifier: Modifier = Modifier
) {
    val historial by viewModel.historial.collectAsState()
    var reparacionAEditar by remember { mutableStateOf<Reparacion?>(null) }
    var reparacionAEliminar by remember { mutableStateOf<Reparacion?>(null) }

    val grupos = remember(historial) { historial.groupBy { Formato.fecha(it.fecha) } }

    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)
    ) {
        Text(
            text = stringResource(R.string.historial_titulo),
            style = MaterialTheme.typography.headlineSmall,
            modifier = Modifier.padding(vertical = 16.dp)
        )

        if (historial.isEmpty()) {
            Text(
                text = stringResource(R.string.historial_vacio),
                style = MaterialTheme.typography.bodyLarge,
                color = MaterialTheme.colorScheme.onSurfaceVariant
            )
        } else {
            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                contentPadding = PaddingValues(bottom = 24.dp),
                verticalArrangement = Arrangement.spacedBy(8.dp)
            ) {
                grupos.forEach { (fecha, trabajos) ->
                    item(key = "cabecera-$fecha") {
                        Text(
                            text = fecha,
                            style = MaterialTheme.typography.titleSmall,
                            color = MaterialTheme.colorScheme.primary,
                            modifier = Modifier.padding(top = 8.dp, bottom = 4.dp)
                        )
                    }
                    items(trabajos, key = { it.id }) { reparacion ->
                        FilaReparacion(
                            reparacion = reparacion,
                            onEditar = { reparacionAEditar = reparacion },
                            onEliminar = { reparacionAEliminar = reparacion }
                        )
                    }
                }
            }
        }
    }

    reparacionAEditar?.let { reparacion ->
        DialogoEditar(
            reparacion = reparacion,
            onGuardar = { modificada ->
                viewModel.actualizar(modificada)
                reparacionAEditar = null
            },
            onCancelar = { reparacionAEditar = null }
        )
    }

    reparacionAEliminar?.let { reparacion ->
        AlertDialog(
            onDismissRequest = { reparacionAEliminar = null },
            title = { Text(stringResource(R.string.eliminar)) },
            text = { Text(stringResource(R.string.confirmar_eliminar)) },
            confirmButton = {
                TextButton(
                    onClick = {
                        viewModel.eliminar(reparacion.id)
                        reparacionAEliminar = null
                    }
                ) {
                    Text(stringResource(R.string.eliminar))
                }
            },
            dismissButton = {
                TextButton(onClick = { reparacionAEliminar = null }) {
                    Text(stringResource(R.string.cancelar))
                }
            }
        )
    }
}

@Composable
private fun FilaReparacion(
    reparacion: Reparacion,
    onEditar: () -> Unit,
    onEliminar: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Row(
            modifier = Modifier.padding(start = 16.dp, top = 4.dp, bottom = 4.dp, end = 4.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Column(
                modifier = Modifier.weight(1f),
                verticalArrangement = Arrangement.spacedBy(2.dp)
            ) {
                Text(
                    text = reparacion.marca,
                    style = MaterialTheme.typography.titleMedium
                )
                Text(
                    text = reparacion.tipo.etiqueta,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
                HorizontalDivider(modifier = Modifier.padding(vertical = 2.dp))
                Text(
                    text = Formato.fechaHora(reparacion.fecha),
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            Text(
                text = Formato.dinero(reparacion.precio),
                style = MaterialTheme.typography.titleMedium,
                color = MaterialTheme.colorScheme.primary,
                modifier = Modifier.padding(end = 8.dp)
            )

            IconButton(onClick = onEditar) {
                Icon(
                    imageVector = Icons.Filled.Edit,
                    contentDescription = stringResource(R.string.editar)
                )
            }
            IconButton(onClick = onEliminar) {
                Icon(
                    imageVector = Icons.Filled.Delete,
                    contentDescription = stringResource(R.string.eliminar)
                )
            }
        }
    }
}

@Composable
private fun DialogoEditar(
    reparacion: Reparacion,
    onGuardar: (Reparacion) -> Unit,
    onCancelar: () -> Unit
) {
    val (marcaInicial, modeloInicial) = remember(reparacion.id) {
        Marcas.separar(reparacion.marca)
    }

    var marca by rememberSaveable(reparacion.id) { mutableStateOf(marcaInicial) }
    var modelo by rememberSaveable(reparacion.id) { mutableStateOf(modeloInicial) }
    var tipoNombre by rememberSaveable(reparacion.id) { mutableStateOf(reparacion.tipo.name) }
    var precio by rememberSaveable(reparacion.id) {
        mutableStateOf(String.format(Locale.US, "%.2f", reparacion.precio))
    }
    var errorMarca by rememberSaveable(reparacion.id) { mutableStateOf(false) }
    var errorPrecio by rememberSaveable(reparacion.id) { mutableStateOf(false) }

    AlertDialog(
        onDismissRequest = onCancelar,
        title = { Text(stringResource(R.string.editar_titulo)) },
        text = {
            FormularioReparacion(
                marca = marca,
                onMarca = { marca = it; errorMarca = false },
                modelo = modelo,
                onModelo = { modelo = it },
                errorMarca = errorMarca,
                tipo = TipoTrabajo.desdeNombre(tipoNombre),
                onTipo = { tipoNombre = it.name },
                precio = precio,
                onPrecio = { precio = it; errorPrecio = false },
                errorPrecio = errorPrecio
            )
        },
        confirmButton = {
            TextButton(
                onClick = {
                    val monto = precio.replace(',', '.').toDoubleOrNull()
                    errorMarca = marca.isBlank()
                    errorPrecio = monto == null || monto <= 0.0

                    if (!errorMarca && !errorPrecio && monto != null) {
                        onGuardar(
                            reparacion.copy(
                                marca = listOf(marca.trim(), modelo.trim())
                                    .filter { it.isNotEmpty() }
                                    .joinToString(" "),
                                tipo = TipoTrabajo.desdeNombre(tipoNombre),
                                precio = monto
                            )
                        )
                    }
                }
            ) {
                Text(stringResource(R.string.guardar_cambios))
            }
        },
        dismissButton = {
            TextButton(onClick = onCancelar) {
                Text(stringResource(R.string.cancelar))
            }
        }
    )
}
