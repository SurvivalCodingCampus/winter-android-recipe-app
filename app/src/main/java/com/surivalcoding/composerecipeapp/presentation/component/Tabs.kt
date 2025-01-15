import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import com.surivalcoding.composerecipeapp.ui.AppColors

@Composable
fun CustomTabs(
    labels: List<String>,
    selectedIndex: Int,
    onValueChange: (Int) -> Unit,
) {
    Column {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.White)
                .padding(10.dp)
        ) {
            Row {
                labels.forEachIndexed { index, label ->
                    Box(
                        modifier = Modifier
                            .weight(1f)
                            .clickable {
                                onValueChange(index)
                            }
                            .background(
                                color = if (index == selectedIndex) AppColors.primary100 else Color.White,
                                shape = RoundedCornerShape(8.dp)
                            )
                            .padding(8.dp)
                    ) {
                        Text(
                            text = label,
                            color = if (index == selectedIndex) Color.White else AppColors.primary100,
                            modifier = Modifier.align(Alignment.Center)
                        )
                    }
                }
            }
        }
    }

}

@Preview
@Composable
fun CustomTabsPreview() {
//    var selectedTabIndex by remember { mutableStateOf(0) }
    CustomTabs(
        labels = listOf("Label", "Label"),
        selectedIndex = 0,
        onValueChange = { newIndex ->
//            selectedTabIndex = newIndex
        }
    )
}

@Preview
@Composable
fun CustomTabsPreview2() {
    CustomTabs(
        labels = listOf("Label", "Label"),
        selectedIndex = 1,
        onValueChange = { newIndex ->
        }
    )
}