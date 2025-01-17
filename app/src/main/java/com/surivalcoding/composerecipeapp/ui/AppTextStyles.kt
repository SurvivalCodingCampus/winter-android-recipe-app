package com.surivalcoding.composerecipeapp.ui

import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R

object AppTextStyles {
    private val poppinsFamily = FontFamily(
        Font(R.font.poppins_bold, FontWeight.Bold),
        Font(R.font.poppins_regular, FontWeight.Normal),
    )

    val normalTextBold = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = poppinsFamily,
    )

    val smallerTextBold = TextStyle(
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = poppinsFamily,
    )

    val smallerTextRegular = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = poppinsFamily,
    )

    val smallerTextLabel = TextStyle(
        fontSize = 8.sp,
        lineHeight = 12.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = poppinsFamily,
    )

    val headerTextBold = TextStyle(
        fontSize = 30.sp,
        lineHeight = 45.sp,
        fontWeight = FontWeight.W600,
        fontFamily = poppinsFamily,
    )

    val largeTextRegular = TextStyle(
        fontSize = 20.sp,
        lineHeight = 30.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = poppinsFamily,
    )

    val smallerTextSemiBold = TextStyle(
        fontSize = 11.sp,
        lineHeight = 17.sp,
        fontWeight = FontWeight.W500,
        fontFamily = poppinsFamily,
    )

    val largeTextBold = TextStyle(
        fontSize = 20.sp,
        lineHeight = 30.sp,
        fontWeight = FontWeight.W600,
        fontFamily = poppinsFamily,
    )
}