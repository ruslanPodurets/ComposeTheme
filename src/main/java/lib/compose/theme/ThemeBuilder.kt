package lib.compose.theme

import android.os.Build
import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.ColorScheme
import androidx.compose.material3.dynamicDarkColorScheme
import androidx.compose.material3.dynamicLightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalContext
import androidx.compose.material3.Typography

class ThemeBuilder {

    class ThemeBuilderParams(
        val isUseSystemDynamicColors: Boolean,
        val darkColorScheme: ColorScheme,
        val lightColorScheme: ColorScheme,
        val typography: Typography
    )

    @Composable
    fun buildThemeInfo(themeBuilderParams: ThemeBuilderParams): IThemeInfo {
        val isSystemInDarkTheme = isSystemInDarkTheme()
        val colorScheme =
            if (themeBuilderParams.isUseSystemDynamicColors && Build.VERSION.SDK_INT >= Build.VERSION_CODES.S) {
                val context = LocalContext.current
                if (isSystemInDarkTheme) dynamicDarkColorScheme(context) else dynamicLightColorScheme(
                    context
                )
            } else if (isSystemInDarkTheme) {
                themeBuilderParams.darkColorScheme
            } else {
                themeBuilderParams.lightColorScheme
            }
        return IThemeInfo.create(colorScheme, themeBuilderParams.typography, isSystemInDarkTheme)
    }

}