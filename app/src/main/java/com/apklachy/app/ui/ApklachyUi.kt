package com.apklachy.app.ui

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.List
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.stringResource
import androidx.lifecycle.viewmodel.compose.viewModel
import com.apklachy.app.R
import com.apklachy.app.ui.estadisticas.EstadisticasScreen
import com.apklachy.app.ui.historial.HistorialScreen
import com.apklachy.app.ui.registro.RegistroScreen
import com.apklachy.app.ui.theme.ApklachyTheme

private data class Pestana(
    val icono: ImageVector,
    val titulo: Int
)

private val pestanas = listOf(
    Pestana(Icons.Filled.Add, R.string.nav_registro),
    Pestana(Icons.Filled.DateRange, R.string.nav_estadisticas),
    Pestana(Icons.Filled.List, R.string.nav_historial)
)

@Composable
fun ApklachyUi() {
    ApklachyTheme {
        val viewModel: AppViewModel = viewModel(factory = AppViewModel.Factory)
        var seleccionada by rememberSaveable { mutableStateOf(0) }

        Scaffold(
            bottomBar = {
                NavigationBar {
                    pestanas.forEachIndexed { indice, pestana ->
                        NavigationBarItem(
                            selected = seleccionada == indice,
                            onClick = { seleccionada = indice },
                            icon = {
                                Icon(
                                    imageVector = pestana.icono,
                                    contentDescription = stringResource(pestana.titulo)
                                )
                            },
                            label = { Text(stringResource(pestana.titulo)) }
                        )
                    }
                }
            }
        ) { interno ->
            val contenido = Modifier.padding(interno)
            when (seleccionada) {
                0 -> RegistroScreen(viewModel, contenido)
                1 -> EstadisticasScreen(viewModel, contenido)
                else -> HistorialScreen(viewModel, contenido)
            }
        }
    }
}
