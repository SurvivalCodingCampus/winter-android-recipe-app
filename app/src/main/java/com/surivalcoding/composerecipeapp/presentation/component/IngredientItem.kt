package com.surivalcoding.composerecipeapp.presentation.component

import android.graphics.drawable.ColorDrawable
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.layout.wrapContentWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalInspectionMode
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil3.compose.AsyncImage
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun IngredientItem(
    modifier: Modifier = Modifier,
    name: String,
    amount: Int,) {
    /*val imageUrl =
        "https://s3-alpha-sig.figma.com/img/3c30/4e61/3dd3e1dd1f7360a6ef1c04399b0609ab?Expires=1737936000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=YiqyiHT-Zf75PgFIhZQxqfcESF8MKWPUTlonvU3jheAOVv1huhxp7SglpH7uoZSIVWGlyY~u1IteavPE54fgxHO8G1XfSznhjP3U1uT5kX9gQVO7BAyrhf25xjiugekaJnOFlKBlgOAorCpNeCMxmvknb9UB6nqpASrBrkg0GAxt0ENYDZawsQ3rArK5ix7Xk0djrw33wYMpggc~4AvJ1QOJdlWag0Y2A9YrXPjf1rutmfTJ3d3GWYbrR1nPmAzAcTFbUGz40NJjEBQRJqgYlkNxb33zpUh6NzDrzZp-RGURdUYHrK-8JwhKUmjgjfWqR9fP-j5PUhHkn7MRdGVe3w__"
    Row(
        modifier = Modifier
            .fillMaxWidth(1f)
            .height(76.dp)
            .background(color = AppColors.gray, shape = RoundedCornerShape(20.dp)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Spacer(
            modifier = Modifier
                .weight(0.03f)
        )
        Box(
            modifier = Modifier
                .weight(0.16f)
                .height(52.dp),
            contentAlignment = Alignment.Center
        ) {
            AsyncImage(
                model = if (LocalInspectionMode.current) {
                    ColorDrawable(Color.Red.toArgb())
                } else {
                    imageUrl
                },
                modifier = Modifier
                    .width(52.dp)
                    .height(52.dp),
                contentDescription = null
            )
        }
        Spacer(
            modifier = Modifier
                .weight(0.05f)
        )
        Box(
            modifier = Modifier
                .wrapContentWidth()
                .height(54.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "Tomatoes",
                fontSize = 16.sp,
                fontWeight = FontWeight.Bold
            )
        }
        Spacer(
            modifier = Modifier
                .weight(0.34f)
        )
        Box(
            modifier = Modifier
                .weight(0.11f)
                .height(21.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = "500g",
                fontSize = 14.sp,
                color = AppColors.darkgray
            )
        }
    }*/
    val imageUrl =
        "https://s3-alpha-sig.figma.com/img/3c30/4e61/3dd3e1dd1f7360a6ef1c04399b0609ab?Expires=1737936000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=YiqyiHT-Zf75PgFIhZQxqfcESF8MKWPUTlonvU3jheAOVv1huhxp7SglpH7uoZSIVWGlyY~u1IteavPE54fgxHO8G1XfSznhjP3U1uT5kX9gQVO7BAyrhf25xjiugekaJnOFlKBlgOAorCpNeCMxmvknb9UB6nqpASrBrkg0GAxt0ENYDZawsQ3rArK5ix7Xk0djrw33wYMpggc~4AvJ1QOJdlWag0Y2A9YrXPjf1rutmfTJ3d3GWYbrR1nPmAzAcTFbUGz40NJjEBQRJqgYlkNxb33zpUh6NzDrzZp-RGURdUYHrK-8JwhKUmjgjfWqR9fP-j5PUhHkn7MRdGVe3w__"

    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(76.dp)
            .background(color = AppColors.gray_04, shape = RoundedCornerShape(20.dp))
            .padding(horizontal = 15.dp, vertical = 12.dp)
    ) {
        Box(
            contentAlignment = Alignment.CenterStart
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.spacedBy(space = 16.dp)
            ) {
                Box(
                    modifier = Modifier
                        .size(52.dp)
                        .clip(shape = RoundedCornerShape(10.dp))
                ) {
                    AsyncImage(
                        model = if (LocalInspectionMode.current) {
                            ColorDrawable(Color.Red.toArgb())
                        } else {
                            imageUrl
                        },
                        contentDescription = null
                    )
                }

                Text(
                    modifier = Modifier
                        .width(90.dp)
                        .height(24.dp),
                    text = name,
                    style = AppTextStyles.normalTextBold,
                    color = AppColors.Label_Colour
                )
            }

        }

        Text(
            modifier = Modifier
                .width(36.dp)
                .height(21.dp)
                .align(
                    alignment = Alignment.CenterEnd
                ),
            text = "${amount}g",
            style = AppTextStyles.smallTextRegular,
            color = AppColors.gray_03
        )
    }
}

@Preview(showBackground = true)
@Composable
private fun IngredientItemPreview() {
    IngredientItem(
        name = "Tomatoes",
        amount = 500
    )
}

