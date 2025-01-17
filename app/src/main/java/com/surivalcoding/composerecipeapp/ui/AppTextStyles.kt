package com.surivalcoding.composerecipeapp.ui

import androidx.compose.material3.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R

object AppTextStyles {
    private val poppinsFamily = FontFamily(
        Font(R.font.poppins_bold, FontWeight.Bold),
        Font(R.font.poppins_regular)
    )

    // Bold Styles
    val boldTitle = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 50.sp,
        lineHeight = 75.sp
    )

    val boldHeader = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp,
        lineHeight = 45.sp
    )

    val boldLarge = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        lineHeight = 30.sp
    )

    val boldMedium = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        lineHeight = 27.sp
    )

    val boldNormal = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 16.sp,
        lineHeight = 24.sp
    )

    val boldSmall = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        lineHeight = 21.sp
    )

    val boldSmaller = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 11.sp,
        lineHeight = 17.sp
    )

    // Regular Styles
    val regularTitle = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 50.sp,
        lineHeight = 75.sp
    )

    val regularHeader = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 30.sp,
        lineHeight = 45.sp
    )

    val regularLarge = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 20.sp,
        lineHeight = 30.sp
    )

    val regularMedium = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 18.sp,
        lineHeight = 27.sp
    )

    val regularNormal = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp,
        lineHeight = 24.sp
    )

    val regularSmall = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        lineHeight = 21.sp
    )

    val regularSmaller = TextStyle(
        fontFamily = poppinsFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 11.sp,
        lineHeight = 17.sp
    )

}


object AppTypography {
    private val poppinsFamily = FontFamily(
        Font(R.font.poppins_bold, FontWeight.Bold),
        Font(R.font.poppins_regular)
    )

    val typography = Typography(
        displayLarge = TextStyle(
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 50.sp,
            lineHeight = 75.sp
        ),
        displayMedium = TextStyle(
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            lineHeight = 45.sp
        ),
        displaySmall = TextStyle(
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Bold,
            fontSize = 20.sp,
            lineHeight = 30.sp
        ),
        headlineLarge = TextStyle(
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 18.sp,
            lineHeight = 27.sp
        ),
        headlineMedium = TextStyle(
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 16.sp,
            lineHeight = 24.sp
        ),
        headlineSmall = TextStyle(
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 14.sp,
            lineHeight = 21.sp
        ),
        titleLarge = TextStyle(
            fontFamily = poppinsFamily,
            fontWeight = FontWeight.Normal,
            fontSize = 11.sp,
            lineHeight = 17.sp
        )
    )

    // Additional text styles
    val normalTextBold = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = poppinsFamily
    )
}