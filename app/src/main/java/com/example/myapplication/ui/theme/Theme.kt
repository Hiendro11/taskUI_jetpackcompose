package com.example.myapplication.ui.theme

import android.app.Activity
import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext

private val DarkColorScheme = darkColorScheme(
    primary = Color(0xFF1F1F1F),     // Dark Gray, primary color for a subtle dark look
    secondary = Color(0xFF37474F),   // Darker Blue-Gray for secondary elements
    tertiary = Color(0xFF4CAF50),    // Dark Green for tertiary elements (e.g., action buttons)
    background = Color(0xFF121212),  // Almost black background
    surface = Color(0xFF222222),     // Dark surface color for cards, dialogs, etc.
    onPrimary = Color.White,         // White text on primary color
    onSecondary = Color.White,       // White text on secondary color
    onBackground = Color(0xFFE0E0E0),// Light gray text on dark background
    onSurface = Color(0xFFE0E0E0)    // Light gray text on dark surface
)

private val LightColorScheme = lightColorScheme(
    primary = Color(0xFF6200EE),     // Indigo, a primary color suitable for light themes
    secondary = Color(0xFF03A9F4),   // Light Blue, adds a cool accent
    tertiary = Color(0xFF4CAF50),    // Green, for tertiary accents (e.g., action buttons)
    background = Color(0xFFFFFFFF),  // White background for light theme
    surface = Color(0xFFF5F5F5),     // Very light gray for surfaces (cards, dialogs, etc.)
    onPrimary = Color.White,         // White text on primary color
    onSecondary = Color.White,       // White text on secondary color
    onBackground = Color.Black,      // Black text on light background
    onSurface = Color(0xFF333333)    // Dark gray text on surfaces

)

@Composable
fun MyApplicationTheme(
    darkTheme: Boolean = isSystemInDarkTheme(),
    // Dynamic color is available on Android 12+
    dynamicColor: Boolean = true,
    content: @Composable () -> Unit
) {
    val colorScheme = when {
        dynamicColor && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S -> {
            val context = LocalContext.current
            if (darkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(context)
        }

        darkTheme -> DarkColorScheme
        else -> LightColorScheme
    }

    MaterialTheme(
        colorScheme = colorScheme,
        typography = Typography,
        content = content
    )
}