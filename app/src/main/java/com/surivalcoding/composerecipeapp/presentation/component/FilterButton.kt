package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors

@Composable
fun FilterButton(
    modifier: Modifier = Modifier,
) {
    Button(
        modifier = Modifier
            .size(40.dp)
            .background(
                color = AppColors.primary100,
                shape = RoundedCornerShape(size = 10.dp)
            ),
        colors = ButtonDefaults.buttonColors(
            containerColor = Color.Transparent,
        ),

        contentPadding = PaddingValues(0.dp),
        onClick = {},
    ) {
        Icon(
            modifier = Modifier.size(20.dp),
            painter = painterResource(id = R.drawable.filter_icon),
            contentDescription = null,
            tint = AppColors.white,
        )
    }
}