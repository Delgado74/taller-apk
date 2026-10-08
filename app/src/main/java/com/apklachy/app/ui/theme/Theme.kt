package com.apklachy.app.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val VerdeTrabajo = Color(0xFF1B5E20)
private val VerdeClaro = Color(0xFF4C8C4A)
private val AmbarHerramienta = Color(0xFFFFC107)

private val EsquemaClaro = lightColorScheme(
    primary = VerdeTrabajo,
    onPrimary = Color.White,
    primaryContainer = Color(0xFFC8E6C9),
    onPrimaryContainer = Color(0xFF0B3D10),
    secondary = VerdeClaro,
    onSecondary = Color.White,
    tertiary = AmbarHerramienta,
    onTertiary = Color(0xFF3E2B00)
)

private val EsquemaOscuro = darkColorScheme(
    primary = Color(0xFF81C784),
    onPrimary = Color(0xFF0B3D10),
    primaryContainer = Color(0xFF2E5130),
    onPrimaryContainer = Color(0xFFC8E6C9),
    secondary = Color(0xFFA5D6A7),
    onSecondary = Color(0xFF0B3D10),
    tertiary = AmbarHerramienta,
    onTertiary = Color(0xFF3E2B00)
)

@Composable
fun ApklachyTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (darkTheme) EsquemaOscuro else EsquemaClaro,
        content = content
    )
}
