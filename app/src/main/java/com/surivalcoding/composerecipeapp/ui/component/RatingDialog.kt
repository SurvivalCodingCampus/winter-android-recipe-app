package com.surivalcoding.composerecipeapp.ui.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.surivalcoding.composerecipeapp.ui.custom.NoPaddingButton
import com.surivalcoding.composerecipeapp.ui.icon.AppIcons
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun RatingDialog(
    onSend: () -> Unit,
    rating: Int = 0,
    onDismiss: () -> Unit,
    onRatingChanged: (Int) -> Unit,
    modifier: Modifier = Modifier
) {
    Dialog(
        properties = DialogProperties(usePlatformDefaultWidth = false),
        onDismissRequest = { onDismiss() },
    ) {
        Card(
            modifier = modifier,
            shape = RoundedCornerShape(8.dp),
        ) {
            Column(
                modifier = Modifier
                    .background(AppColors.White)
                    .padding(horizontal = 15.dp, vertical = 10.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(5.dp)
            ) {
                Text(
                    text = "Rate recipe",
                    style = AppTextStyles.smallTextRegular
                )
                RatingBar(
                    rating = rating,
                    onRatingChanged = onRatingChanged,
                )
                NoPaddingButton(
                    onClick = onSend,
                    contentPadding = PaddingValues(20.dp, 4.dp),
                    shape = RoundedCornerShape(6.dp),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AppColors.Rating,
                        contentColor = AppColors.White,
                        disabledContainerColor = AppColors.Gray4,
                        disabledContentColor = AppColors.White,
                    )
                ) {
                    Text(
                        text = "Send",
                        style = AppTextStyles.smallerTextSmallLabel
                    )
                }
            }
        }
    }
}

@Composable
fun RatingBar(
    rating: Int,
    onRatingChanged: (Int) -> Unit,
    modifier: Modifier = Modifier,
    maxRating: Int = 5,
) {
    Row(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(10.dp)
    ) {
        repeat(maxRating) { starCount ->
            Icon(
                imageVector = if (starCount < rating) AppIcons.starRate else AppIcons.starBorder,
                contentDescription = null,
                modifier = Modifier
                    .size(20.dp)
                    .clickable { onRatingChanged(starCount) },
                tint = AppColors.Rating
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun RatingDialogPreview() {
    ComposeRecipeAppTheme {
        RatingDialog(
            onDismiss = {},
            onSend = {},
            rating = 2,
            onRatingChanged = {}
        )
    }
}