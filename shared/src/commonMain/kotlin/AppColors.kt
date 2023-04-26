import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.ui.graphics.Color

val appBlack: Color = Color(0xff25242b)
val appYellow: Color = Color(0xffffb400)
val appWhite: Color = Color(0xffffffff)

val LightThemeColors = lightColors(
    primary = appYellow,
    primaryVariant = appYellow,
    background = appWhite,
    secondary = appBlack
)

val DarkThemeColors = darkColors(
    primary = appYellow,
    primaryVariant = appYellow,
    background = appBlack,
    secondary = appWhite
)