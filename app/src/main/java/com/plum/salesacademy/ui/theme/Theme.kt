package com.plum.salesacademy.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color

private val PlumPurple = Color(0xFF6A1B9A)
private val PlumLavender = Color(0xFFEADCF5)

private val LightColors = lightColorScheme(
    primary = PlumPurple,
    secondary = Color(0xFF8E24AA),
    tertiary = Color(0xFFAB47BC),
    surfaceVariant = PlumLavender
)

@Composable
fun PlumTheme(content: @Composable () -> Unit) {
    MaterialTheme(
        colorScheme = LightColors,
        typography = Typography(),
        content = content
    )
}
