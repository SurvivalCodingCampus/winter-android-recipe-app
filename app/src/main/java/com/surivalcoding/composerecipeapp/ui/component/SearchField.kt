package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.custom.HoOutlinedTextField
import com.surivalcoding.composerecipeapp.ui.icon.AppIcons
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles

@Composable
fun SearchField(
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    HoOutlinedTextField(
        value = value,
        enabled = enabled,
        onValueChange = onValueChange,
        textStyle = AppTextStyles.smallerTextRegular.copy(
            color = AppColors.Black
        ),
        singleLine = true,
        placeholder = {
            Text(
                text = "Search recipe",
                color = AppColors.Gray4,
            )
        },
        prefix = {
            Icon(
                imageVector = ImageVector.vectorResource(AppIcons.searchNormal),
                contentDescription = null,
                tint = AppColors.Gray4,
                modifier = Modifier
                    .padding(end = 10.dp)
                    .size(18.dp)
            )
        },
        borderColor = AppColors.Primary100,
        borderWidth = 1.3.dp,
        shape = RoundedCornerShape(10.dp),
        innerPadding = PaddingValues(horizontal = 10.dp, vertical = 11.dp),
        modifier = modifier,
    )
}