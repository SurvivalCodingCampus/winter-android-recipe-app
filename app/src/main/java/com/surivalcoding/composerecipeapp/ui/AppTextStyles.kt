package com.surivalcoding.composerecipeapp.ui

import AppColors
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.R

object AppTextStyles {
    private val poppinsFamily = FontFamily(
        Font(R.font.poppins_bold, FontWeight.Bold),
        Font(R.font.poppins_regular, FontWeight.W400)
    )

    val normalTextBold = TextStyle(
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        fontFamily = poppinsFamily,
    )

    val normalTextSemiBold = TextStyle(
        fontSize = 11.sp,
        fontWeight = FontWeight.W400,
        fontFamily = poppinsFamily,
        color = AppColors.gray4
    )

    val normalTextRegular = TextStyle(
        fontSize = 14.sp,
        fontWeight = FontWeight.W400,
        fontFamily = poppinsFamily,
        color = Color.Black
    )
}