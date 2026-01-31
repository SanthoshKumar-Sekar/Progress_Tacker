package com.example.progress_tracker.ui.theme

import android.graphics.Color
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.core.graphics.toColor

private val DarkColorScheme = CustomColorScheme(
    primaryBackgroundColor = Color.BLACK.toColor()
)

private val LightColorScheme = CustomColorScheme(
    primaryBackgroundColor = Color.WHITE.toColor()
)


 class CustomColorScheme(
    primaryBackgroundColor: Color
)


@Composable
fun ProgressTrackerTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(

        content = content
    )
}