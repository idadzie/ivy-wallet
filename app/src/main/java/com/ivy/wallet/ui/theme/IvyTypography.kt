package com.ivy.wallet.ui.theme

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.sp
import com.ivy.wallet.R

val OpenSans = FontFamily(
        Font(R.font.opensans_regular, FontWeight.Normal),
        Font(R.font.opensans_regular, FontWeight.Medium),
        Font(R.font.opensans_bold, FontWeight.Black),
        Font(R.font.opensans_semibold, FontWeight.SemiBold),
        Font(R.font.opensans_bold, FontWeight.Bold),
        Font(R.font.opensans_extrabold, FontWeight.ExtraBold),
)

val RaleWay = FontFamily(
        Font(R.font.raleway_regular, FontWeight.Normal),
        Font(R.font.raleway_medium, FontWeight.Medium),
        Font(R.font.raleway_black, FontWeight.Black),
        Font(R.font.raleway_light, FontWeight.Light),
        Font(R.font.raleway_semibold, FontWeight.SemiBold),
        Font(R.font.raleway_bold, FontWeight.Bold),
        Font(R.font.raleway_extrabold, FontWeight.ExtraBold),
)

private const val H1 = 40
private const val H2 = 32
private const val B1 = 18
private const val B2 = 16
private const val CAPTION = 12

val Typo = IvyTypography(
        h1 = TextStyle(
                fontFamily = RaleWay,
                fontWeight = FontWeight.Black,
                fontSize = H1.sp
        ),
        h2 = TextStyle(
                fontFamily = RaleWay,
                fontWeight = FontWeight.Normal,
                fontSize = H2.sp
        ),
        body1 = TextStyle(
                fontFamily = RaleWay,
                fontWeight = FontWeight.ExtraBold,
                fontSize = B1.sp
        ),
        body2 = TextStyle(
                fontFamily = RaleWay,
                fontWeight = FontWeight.Medium,
                fontSize = B2.sp
        ),
        caption = TextStyle(
                fontFamily = RaleWay,
                fontWeight = FontWeight.ExtraBold,
                fontSize = CAPTION.sp
        ),

        numberH1 = TextStyle(
                fontFamily = OpenSans,
                fontWeight = FontWeight.Bold,
                fontSize = H1.sp
        ),
        numberH2 = TextStyle(
                fontFamily = OpenSans,
                fontWeight = FontWeight.Normal,
                fontSize = H2.sp
        ),
        numberBody1 = TextStyle(
                fontFamily = OpenSans,
                fontWeight = FontWeight.Bold,
                fontSize = B1.sp
        ),
        numberBody2 = TextStyle(
                fontFamily = OpenSans,
                fontWeight = FontWeight.Normal,
                fontSize = B2.sp
        ),
        numberCaption = TextStyle(
                fontFamily = OpenSans,
                fontWeight = FontWeight.Bold,
                fontSize = CAPTION.sp
        ),
)

data class IvyTypography(
        val h1: TextStyle,
        val h2: TextStyle,
        val body1: TextStyle,
        val body2: TextStyle,
        val caption: TextStyle,

        val numberH1: TextStyle,
        val numberH2: TextStyle,
        val numberBody1: TextStyle,
        val numberBody2: TextStyle,
        val numberCaption: TextStyle
)

fun TextStyle.colorAs(color: Color) = this.copy(color = color)

@Composable
fun TextStyle.style(
        color: Color = IvyTheme.colors.pureInverse,
        fontWeight: FontWeight = FontWeight.Bold,
        textAlign: TextAlign = TextAlign.Start
) = this.copy(
        color = color,
        fontWeight = fontWeight,
        textAlign = textAlign
)