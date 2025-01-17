import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.AppColors

@Composable
fun RatingButton(
    labels: List<String>,
    selectedIndex: Int,
    onValueChange: (Int) -> Unit
) {
    Box(
        modifier = Modifier
            .width(200.dp)
            .fillMaxWidth()
            .background(Color.White)
            .padding(10.dp)
    ) {
        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(8.dp) // 버튼 간 간격 추가
        ) {
            labels.forEachIndexed { index, label ->
                Box(
                    modifier = Modifier
                        .weight(1f)
                        .clickable { onValueChange(index) }
                        .background(
                            color = if (index == selectedIndex) AppColors.primary100 else Color.White,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .border(
                            width = 1.dp,
                            color = if (index == selectedIndex) Color.Transparent else AppColors.primary100,
                            shape = RoundedCornerShape(8.dp)
                        )
                        .padding(vertical = 8.dp, horizontal = 16.dp),
                    contentAlignment = Alignment.Center
                ) {
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = label,
                            color = if (index == selectedIndex) Color.White else AppColors.primary100
                        )
                        Spacer(modifier = Modifier.width(4.dp))
                        Icon(
                            imageVector = Icons.Default.Star,
                            contentDescription = "Star Icon",
                            tint = if (index == selectedIndex) Color.White else AppColors.primary100,
                            modifier = Modifier.size(16.dp)
                        )
                    }
                }
            }
        }
    }
}

@Preview
@Composable
fun RatingButtonPreview() {
    var selectedTabIndex by remember { mutableStateOf(1) }

    RatingButton(
        labels = listOf("5", "5"),
        selectedIndex = selectedTabIndex,
        onValueChange = { newIndex ->
            selectedTabIndex = newIndex // 선택된 인덱스 갱신
        }
    )
}


