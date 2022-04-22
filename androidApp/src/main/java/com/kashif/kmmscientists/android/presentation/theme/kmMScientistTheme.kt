package com.kashif.kmmscientists.android.presentation.theme

import android.annotation.SuppressLint
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material.MaterialTheme
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color
import com.google.accompanist.systemuicontroller.rememberSystemUiController


@SuppressLint("ConflictingOnColor")
private val LightThemeColors = lightColors(
    primary = GreenMain,
    primaryVariant = CardGreen,
    onPrimary = GreenMain,
    secondary = Color.White,
    secondaryVariant = GreenMain,
    error = RedErrorDark,
    onError = RedErrorLight,
    background = Color.White,
    onBackground = BlackHeader,
    surface = Color.White,

)

@Composable
fun KmMScientistTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable () -> Unit
) {
    val colors = if (darkTheme) {
       LightThemeColors
    } else {
        LightThemeColors
    }
    val systemUIController = rememberSystemUiController()

    SideEffect {
        systemUIController.setSystemBarsColor(
            if (darkTheme) Color.Black else Color.Black
        )
    }

    MaterialTheme(
        colors = LightThemeColors,
        typography = typography,
        shapes = AppShapes,
        content = content
    )
}