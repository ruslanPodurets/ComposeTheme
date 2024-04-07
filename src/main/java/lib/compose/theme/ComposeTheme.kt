package lib.compose.theme

import android.app.Activity
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat

@Composable
fun ComposeTheme(
    themeInfo: IThemeInfo,
    content: @Composable () -> Unit
) {
    val view = LocalView.current
    if (!view.isInEditMode) {
        SideEffect {
            val viewContext = view.context
            if (viewContext is Activity) {
                val window = viewContext.window
                window.statusBarColor = themeInfo.colorScheme().primary.toArgb()
                WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars =
                    themeInfo.isColorSchemeDark()
            }
        }
    }
    MaterialTheme(
        colorScheme = themeInfo.colorScheme(),
        typography = themeInfo.typography(),
        content = content
    )
}