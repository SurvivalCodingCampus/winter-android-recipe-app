package com.surivalcoding.composerecipeapp.ui

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

    val headerTextBold = TextStyle(
        fontSize = 30.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = poppinsFamily,
        lineHeight = 45.sp
    )

    val largeTextRegular = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = poppinsFamily,
        lineHeight = 30.sp
    )

    val largeTextBold = TextStyle(
        fontSize = 20.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = poppinsFamily,
        lineHeight = 30.sp
    )

    val mediumTextBold = TextStyle(
        fontSize = 18.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = poppinsFamily,
        lineHeight = 27.sp
    )

    val normalTextBold = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = poppinsFamily,
        lineHeight = 24.sp
    )

    val normalTextRegular = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = poppinsFamily,
        lineHeight = 24.sp
    )

    val smallTextBold = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = poppinsFamily,
        lineHeight = 21.sp
    )

    val smallerTextLabel = TextStyle(
        fontSize = 8.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = poppinsFamily,
        lineHeight = 12.sp
    )

    val smallerTextRegular = TextStyle (
        fontSize = 11.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = poppinsFamily,
        lineHeight = 16.5.sp
    )

    val smallerTextSemiBold = TextStyle (
        fontSize = 11.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = poppinsFamily,
        lineHeight = 16.5.sp
    )

    val smallTextRegular = TextStyle (
        fontSize = 14.sp,
        fontWeight = FontWeight.Normal,
        fontFamily = poppinsFamily,
        lineHeight = 21.sp
    )
}