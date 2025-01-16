package com.surivalcoding.composerecipeapp.presentation.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material.icons.outlined.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun RatingDialog(
    title: String = "Rate recipe",
    actionName: String = "Send",
    onRatingChange: (Int) -> Unit,
    onDismiss: () -> Unit
) {
    var rating by remember { mutableIntStateOf(0) }

    Surface(
        modifier = Modifier.padding(horizontal = 24.dp),
        shape = RoundedCornerShape(10.dp),
        color = AppColors.white
    ) {
        Column(
            modifier = Modifier.padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = title,
                style = AppTextStyles.normalTextBold
            )

            Spacer(modifier = Modifier.height(16.dp))

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.Center
            ) {
                repeat(5) { index ->
                    Icon(
                        imageVector = if (index < rating) {
                            Icons.Filled.Star
                        } else {
                            Icons.Outlined.Star
                        },
                        contentDescription = "별점 ${index + 1}점",
                        tint = if (index < rating) {
                            AppColors.secondary100  // 선택된 별: 주황색
                        } else {
                            AppColors.gray4  // 선택되지 않은 별: 회색
                        },
                        modifier = Modifier
                            .padding(horizontal = 4.dp)
                            .clickable { rating = index + 1 }
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Button(
                onClick = {
                    if (rating > 0) {
                        onRatingChange(rating)
                        onDismiss()
                    }
                },
                enabled = rating > 0,
                colors = ButtonDefaults.buttonColors(
                    containerColor = AppColors.secondary100,  // 활성화: 주황색
                    disabledContainerColor = AppColors.gray4  // 비활성화: 회색
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    text = actionName,
                    style = AppTextStyles.smallTextBold.copy(
                        color = if (rating > 0) {
                            AppColors.white
                        } else {
                            AppColors.gray3  // 비활성화된 텍스트: 회색
                        }
                    )
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RatingDialogPreview() {
    RatingDialog(
        onRatingChange = {},
        onDismiss = {}
    )
}