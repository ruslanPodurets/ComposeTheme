package lib.compose.theme

import androidx.compose.material3.ColorScheme
import androidx.compose.material3.Typography

internal class ThemeInfo(
    private val colorScheme: ColorScheme,
    private val typography: Typography,
    private val isColorSchemeDark: Boolean
) : IThemeInfo {
    override fun colorScheme(): ColorScheme = colorScheme

    override fun typography(): Typography = typography

    override fun isColorSchemeDark(): Boolean = isColorSchemeDark
}