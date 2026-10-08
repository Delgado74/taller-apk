package com.apklachy.app.ui.componentes

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.collectIsPressedAsState
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.ExposedDropdownMenuDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MenuAnchorType
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.apklachy.app.R
import com.apklachy.app.data.TipoTrabajo
import com.apklachy.app.util.Marcas

@OptIn(ExperimentalMaterial3Api::class)
@Composable
private fun CampoAutocompletado(
    valor: String,
    onValor: (String) -> Unit,
    opciones: List<String>,
    etiqueta: String,
    ayuda: String? = null,
    error: Boolean,
    modifier: Modifier = Modifier
) {
    var expandido by remember { mutableStateOf(false) }
    val sugerencias = remember(valor, opciones) { Marcas.filtrar(valor, opciones) }

    ExposedDropdownMenuBox(
        expanded = expandido,
        onExpandedChange = { expandido = it },
        modifier = modifier
    ) {
        OutlinedTextField(
            value = valor,
            onValueChange = { nuevo ->
                onValor(nuevo)
                expandido = true
            },
            label = { Text(etiqueta) },
            isError = error,
            singleLine = true,
            supportingText = ayuda?.let { texto ->
                {
                    Text(
                        text = texto,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            },
            trailingIcon = {
                ExposedDropdownMenuDefaults.TrailingIcon(expanded = expandido)
            },
            modifier = Modifier
                .fillMaxWidth()
                .menuAnchor(MenuAnchorType.PrimaryEditable)
        )

        ExposedDropdownMenu(
            expanded = expandido,
            onDismissRequest = { expandido = false }
        ) {
            if (sugerencias.isEmpty()) {
                DropdownMenuItem(
                    text = {
                        Text(
                            text = stringResource(R.string.sin_coincidencias),
                            color = MaterialTheme.colorScheme.onSurfaceVariant
                        )
                    },
                    onClick = { expandido = false }
                )
            }

            sugerencias.forEach { opcion ->
                DropdownMenuItem(
                    text = { Text(opcion) },
                    onClick = {
                        onValor(opcion)
                        expandido = false
                    }
                )
            }
        }
    }
}

@Composable
fun CampoTipo(
    valor: TipoTrabajo,
    onCambio: (TipoTrabajo) -> Unit,
    modifier: Modifier = Modifier
) {
    var expandido by remember { mutableStateOf(false) }
    val interaccion = remember { MutableInteractionSource() }
    val presionado by interaccion.collectIsPressedAsState()

    LaunchedEffect(presionado) {
        if (presionado) expandido = true
    }

    Box(modifier = modifier.fillMaxWidth()) {
        OutlinedTextField(
            value = valor.etiqueta,
            onValueChange = {},
            readOnly = true,
            interactionSource = interaccion,
            label = { Text(stringResource(R.string.campo_tipo)) },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null
                )
            },
            modifier = Modifier.fillMaxWidth()
        )

        DropdownMenu(
            expanded = expandido,
            onDismissRequest = { expandido = false }
        ) {
            TipoTrabajo.entries.forEach { tipo ->
                DropdownMenuItem(
                    text = { Text(tipo.etiqueta) },
                    onClick = {
                        onCambio(tipo)
                        expandido = false
                    }
                )
            }
        }
    }
}

@Composable
fun CampoPrecio(
    valor: String,
    onCambio: (String) -> Unit,
    error: Boolean,
    modifier: Modifier = Modifier
) {
    OutlinedTextField(
        value = valor,
        onValueChange = { nuevo ->
            onCambio(nuevo.filter { car -> car.isDigit() || car == '.' || car == ',' })
        },
        label = { Text(stringResource(R.string.campo_precio)) },
        isError = error,
        singleLine = true,
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Decimal),
        modifier = modifier.fillMaxWidth()
    )
}

@Composable
fun FormularioReparacion(
    marca: String,
    onMarca: (String) -> Unit,
    modelo: String,
    onModelo: (String) -> Unit,
    errorMarca: Boolean,
    tipo: TipoTrabajo,
    onTipo: (TipoTrabajo) -> Unit,
    precio: String,
    onPrecio: (String) -> Unit,
    errorPrecio: Boolean,
    modifier: Modifier = Modifier
) {
    val modelosDeLaMarca = remember(marca) { Marcas.modelosDe(marca) }
    val ayudaModelo = stringResource(
        if (modelosDeLaMarca.isEmpty()) {
            R.string.ayuda_modelo_sin_marca
        } else {
            R.string.ayuda_modelo
        }
    )

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        CampoAutocompletado(
            valor = marca,
            onValor = { nuevo ->
                if (!nuevo.equals(marca, ignoreCase = true)) onModelo("")
                onMarca(nuevo)
            },
            opciones = Marcas.MARCAS,
            etiqueta = stringResource(R.string.campo_marca),
            error = errorMarca
        )
        if (errorMarca) {
            Text(
                text = stringResource(R.string.error_marca),
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }

        CampoAutocompletado(
            valor = modelo,
            onValor = onModelo,
            opciones = modelosDeLaMarca,
            etiqueta = stringResource(R.string.campo_modelo),
            ayuda = ayudaModelo,
            error = false
        )

        CampoTipo(valor = tipo, onCambio = onTipo)

        CampoPrecio(
            valor = precio,
            onCambio = onPrecio,
            error = errorPrecio
        )
        if (errorPrecio) {
            Text(
                text = stringResource(R.string.error_precio),
                color = MaterialTheme.colorScheme.error,
                style = MaterialTheme.typography.bodySmall
            )
        }
    }
}
