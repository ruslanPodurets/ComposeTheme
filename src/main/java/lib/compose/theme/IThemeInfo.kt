package lib.compose.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography

interface IThemeInfo {

    fun colorScheme(): ColorScheme
    fun typography(): Typography
    fun isColorSchemeDark(): Boolean

    companion object{

        fun create(colorScheme: ColorScheme, typography: Typography, isColorSchemeDark: Boolean) : IThemeInfo {
            return ThemeInfo(colorScheme, typography, isColorSchemeDark)
        }

    }

}