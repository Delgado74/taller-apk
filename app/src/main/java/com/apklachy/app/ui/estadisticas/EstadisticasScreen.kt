package com.apklachy.app.ui.estadisticas

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Card
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.LinearProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.apklachy.app.R
import com.apklachy.app.data.Conteo
import com.apklachy.app.data.Estadisticas
import com.apklachy.app.data.TipoTrabajo
import com.apklachy.app.ui.AppViewModel
import com.apklachy.app.util.Formato
import com.apklachy.app.util.Periodo
import com.apklachy.app.util.Rangos

@Composable
fun EstadisticasScreen(
    viewModel: AppViewModel,
    modifier: Modifier = Modifier
) {
    var periodoNombre by rememberSaveable { mutableStateOf(Periodo.DIA.name) }
    var desplazamiento by rememberSaveable { mutableStateOf(0) }

    val periodo = Periodo.entries.firstOrNull { it.name == periodoNombre } ?: Periodo.DIA
    val datos by viewModel.estadisticas.collectAsState()
    val cargando by viewModel.cargando.collectAsState()

    LaunchedEffect(periodoNombre, desplazamiento) {
        viewModel.cargarEstadisticas(periodo, desplazamiento)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(R.string.estadisticas_titulo),
            style = MaterialTheme.typography.headlineSmall
        )

        TabRow(selectedTabIndex = periodo.ordinal) {
            Periodo.entries.forEach { opcion ->
                Tab(
                    selected = opcion == periodo,
                    onClick = {
                        periodoNombre = opcion.name
                        desplazamiento = 0
                    },
                    text = { Text(opcion.etiqueta) }
                )
            }
        }

        SelectorPeriodo(
            periodo = periodo,
            desplazamiento = desplazamiento,
            onCambio = { desplazamiento = it }
        )

        val estado = datos
        when {
            cargando -> Text(
                text = stringResource(R.string.cargando),
                style = MaterialTheme.typography.bodyMedium
            )

            estado == null -> Text(
                text = stringResource(R.string.cargando),
                style = MaterialTheme.typography.bodyMedium
            )

            estado.cantidad == 0 -> Text(
                text = stringResource(R.string.sin_datos),
                style = MaterialTheme.typography.bodyLarge
            )

            else -> ContenidoEstadisticas(estado)
        }
    }
}

@Composable
private fun SelectorPeriodo(
    periodo: Periodo,
    desplazamiento: Int,
    onCambio: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(4.dp)
    ) {
        TextButton(onClick = { onCambio(desplazamiento - 1) }) {
            Text("‹", style = MaterialTheme.typography.headlineSmall)
        }

        Text(
            text = Rangos.etiqueta(periodo, desplazamiento) { Formato.fecha(it) },
            modifier = Modifier.weight(1f),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.titleMedium
        )

        TextButton(onClick = { onCambio(desplazamiento + 1) }) {
            Text("›", style = MaterialTheme.typography.headlineSmall)
        }

        if (desplazamiento != 0) {
            TextButton(onClick = { onCambio(0) }) {
                Text(stringResource(R.string.periodo_actual))
            }
        }
    }
}

@Composable
private fun ContenidoEstadisticas(datos: Estadisticas) {
    Card(modifier = Modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(6.dp)
        ) {
            Text(
                text = stringResource(R.string.cantidad_ganada),
                style = MaterialTheme.typography.titleMedium
            )
            Text(
                text = Formato.dinero(datos.total),
                style = MaterialTheme.typography.headlineMedium,
                color = MaterialTheme.colorScheme.primary
            )
            HorizontalDivider()
            Row(horizontalArrangement = Arrangement.spacedBy(16.dp)) {
                Text(
                    text = "${datos.cantidad} " + stringResource(R.string.trabajos_unidad),
                    style = MaterialTheme.typography.bodyMedium
                )
                Text(
                    text = stringResource(R.string.promedio) + ": " + Formato.dinero(datos.promedio),
                    style = MaterialTheme.typography.bodyMedium
                )
            }
        }
    }

    TarjetaRanking(
        titulo = R.string.marcas_top,
        datos = datos.marcas,
        etiqueta = { it }
    )

    TarjetaRanking(
        titulo = R.string.tipos_top,
        datos = datos.tipos,
        etiqueta = { TipoTrabajo.etiquetaDe(it) }
    )
}

@Composable
private fun TarjetaRanking(
    titulo: Int,
    datos: List<Conteo>,
    etiqueta: (String) -> String,
    modifier: Modifier = Modifier
) {
    Card(modifier = modifier.fillMaxWidth()) {
        Column(
            modifier = Modifier.padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(10.dp)
        ) {
            Text(
                text = stringResource(titulo),
                style = MaterialTheme.typography.titleMedium
            )

            if (datos.isEmpty()) {
                Text(
                    text = stringResource(R.string.sin_datos),
                    style = MaterialTheme.typography.bodyMedium
                )
            }

            val maximo = (datos.maxOfOrNull { it.cantidad } ?: 1).coerceAtLeast(1)

            datos.forEachIndexed { indice, conteo ->
                Column(verticalArrangement = Arrangement.spacedBy(4.dp)) {
                    Row(verticalAlignment = Alignment.CenterVertically) {
                        Text(
                            text = "${indice + 1}.",
                            style = MaterialTheme.typography.bodyMedium,
                            modifier = Modifier.padding(end = 8.dp)
                        )
                        Text(
                            text = etiqueta(conteo.valor),
                            style = MaterialTheme.typography.bodyLarge,
                            modifier = Modifier.weight(1f)
                        )
                        Text(
                            text = "${conteo.cantidad}",
                            style = MaterialTheme.typography.bodyMedium
                        )
                    }
                    LinearProgressIndicator(
                        progress = { conteo.cantidad.toFloat() / maximo.toFloat() },
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}
