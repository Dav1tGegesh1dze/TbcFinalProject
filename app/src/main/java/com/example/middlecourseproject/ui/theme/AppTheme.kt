package com.example.middlecourseproject.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val LightColorPalette = lightColors(
    primary = Color(0xFF00BFFF),
    primaryVariant = Color(0xFF0091EA),
    secondary = Color(0xFFFF5722),
    background = Color(0xFFF5F5F5),
    surface = Color.White
)

private val DarkColorPalette = darkColors(
    primary = Color(0xFF00BFFF),
    primaryVariant = Color(0xFF0091EA),
    secondary = Color(0xFFFF5722),
    background = Color(0xFF121212),
    surface = Color(0xFF1E1E1E)
)

@Composable
fun AppTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
        DarkColorPalette
    } else {
        LightColorPalette
    }

    MaterialTheme(
        colors = colors,
        typography = Typography,
        shapes = Shapes,
        content = content
    )
}