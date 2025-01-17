import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.StarRate
import androidx.compose.material.icons.outlined.StarRate
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun RatingButton(
    rateNumber: Int = 5,
    onClick: () -> Unit
) {
    var isFiltered by remember { mutableStateOf(false) }
    var backgroundColor by remember { mutableStateOf(AppColors.White) }

    Box(
        modifier = Modifier
            .border(
                width = 1.dp,
                color = AppColors.Primary100,
                shape = RoundedCornerShape(size = 10.dp)
            )
            .height(28.dp)
            .width(50.dp)
            .clip(shape = RoundedCornerShape(size = 10.dp))
            .background(color = backgroundColor)
            .padding(start = 10.dp, end = 10.dp, top = 5.dp, bottom = 5.dp)
            .clickable {
                onClick()
                isFiltered = !isFiltered
                backgroundColor = if (isFiltered) AppColors.Primary100 else Color.Transparent
            },
        contentAlignment = Alignment.Center,
    ) {
        Row(
            horizontalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(
                text = rateNumber.toString(), style = AppTextStyles.regularSmall.copy(
                    color = if (!isFiltered) AppColors.Primary100 else AppColors.White
                )
            )
            Icon(
                imageVector = Icons.Filled.StarRate,
                contentDescription = "rating",
                modifier = Modifier.size(18.dp),
                if (!isFiltered) AppColors.Primary100 else AppColors.White
            )

        }

    }
}

@Preview(showBackground = true)
@Composable
private fun RatingButtonPreview() {
    RatingButton(onClick = {
    })

}