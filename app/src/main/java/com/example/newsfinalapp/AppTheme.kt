package com.example.newsfinalapp


import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.staticCompositionLocalOf
import androidx.compose.ui.graphics.Color


@Composable
fun AppTheme (
    content: @Composable () -> Unit,
) {
    CompositionLocalProvider(
        LocalColors provides appColors
    ) {
        content()
    }
}

val appColors = TextColors(
    title = Color(0xFF08080A),
    subtitle = Color(0xFF828282),
    backgroundOfRow = Color(0xFFF1F2F3),
    bottomNavBackground = Color(0xFFFFFFFF),
)

internal val LocalColors = staticCompositionLocalOf { appColors }

data class TextColors(
    val title: Color,
    val subtitle: Color,
    val backgroundOfRow: Color,
    val bottomNavBackground: Color,
)