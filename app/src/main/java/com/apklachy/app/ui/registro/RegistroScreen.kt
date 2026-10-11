package com.apklachy.app.ui.registro

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.apklachy.app.R
import com.apklachy.app.ui.AppViewModel
import com.apklachy.app.ui.componentes.FormularioReparacion
import com.apklachy.app.util.Formato
import kotlinx.coroutines.delay

@Composable
fun RegistroScreen(
    viewModel: AppViewModel,
    modifier: Modifier = Modifier
) {
    var marca by rememberSaveable { mutableStateOf("") }
    var modelo by rememberSaveable { mutableStateOf("") }
    var tipo by rememberSaveable { mutableStateOf("") }
    var precio by rememberSaveable { mutableStateOf("") }
    var errorMarca by rememberSaveable { mutableStateOf(false) }
    var errorTipo by rememberSaveable { mutableStateOf(false) }
    var errorPrecio by rememberSaveable { mutableStateOf(false) }
    var aviso by rememberSaveable { mutableStateOf(false) }

    LaunchedEffect(aviso) {
        if (aviso) {
            delay(2_500)
            aviso = false
        }
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        Text(
            text = stringResource(R.string.registro_titulo),
            style = MaterialTheme.typography.headlineSmall
        )

        Text(
            text = stringResource(
                R.string.registro_fecha,
                Formato.fecha(System.currentTimeMillis())
            ),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.onSurfaceVariant
        )

        FormularioReparacion(
            marca = marca,
            onMarca = { marca = it; errorMarca = false },
            modelo = modelo,
            onModelo = { modelo = it },
            errorMarca = errorMarca,
            tipo = tipo,
            onTipo = { tipo = it; errorTipo = false },
            errorTipo = errorTipo,
            precio = precio,
            onPrecio = { precio = it; errorPrecio = false },
            errorPrecio = errorPrecio
        )

        AnimatedVisibility(visible = aviso) {
            Text(
                text = stringResource(R.string.aviso_guardado),
                color = MaterialTheme.colorScheme.primary,
                style = MaterialTheme.typography.bodyLarge,
                modifier = Modifier.fillMaxWidth()
            )
        }

        Button(
            onClick = {
                val monto = precio.replace(',', '.').toDoubleOrNull()
                errorMarca = marca.isBlank()
                errorTipo = tipo.isBlank()
                errorPrecio = monto == null || monto <= 0.0

                if (!errorMarca && !errorTipo && !errorPrecio && monto != null) {
                    viewModel.guardar(marca.trim(), modelo.trim(), tipo.trim(), monto)
                    marca = ""
                    modelo = ""
                    tipo = ""
                    precio = ""
                    aviso = true
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(52.dp)
        ) {
            Icon(imageVector = Icons.Filled.Check, contentDescription = null)
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = stringResource(R.string.boton_guardar),
                style = MaterialTheme.typography.titleMedium
            )
        }
    }
}
