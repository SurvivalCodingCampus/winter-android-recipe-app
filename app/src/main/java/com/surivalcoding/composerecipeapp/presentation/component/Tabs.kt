//import androidx.compose.foundation.*
//import androidx.compose.foundation.layout.*
//import androidx.compose.foundation.shape.RoundedCornerShape
//import androidx.compose.material3.Text
//import androidx.compose.runtime.*
//import androidx.compose.ui.Alignment
//import androidx.compose.ui.Modifier
//import androidx.compose.ui.graphics.Color
//import androidx.compose.ui.unit.dp
//import androidx.compose.ui.tooling.preview.Preview
//import androidx.compose.ui.unit.Dp
//
//@Composable
//fun CustomTabs(
//    labels: List<String>,
//    selectedIndex: Int,
//    onValueChange: (Int) -> Unit,
////    padding: PaddingValues = PaddingValues(16.dp),
////    tabSpacing: Dp = 8.dp,
////    backgroundColor: Color = Color.White,
////    selectedBackgroundColor: Color = Color.LightGray,
////    textColor: Color = Color.Black,
////    selectedTextColor: Color = Color.Blue
//) {
//    Column {
//        Box(
//            modifier = Modifier
//                .fillMaxWidth()
//                .background(color = backgroundColor)
//                .padding(padding)
//        ) {
//            Row {
//                labels.forEachIndexed { index, label ->
//                    Box(
//                        modifier = Modifier
//                            .weight(1f)
//                            .clickable {
//                                onValueChange(index)
//                            }
//                            .background(
//                                color = if (index == selectedIndex) selectedBackgroundColor else backgroundColor,
//                                shape = RoundedCornerShape(8.dp)
//                            )
//                            .padding(8.dp)
//                    ) {
//                        Text(
//                            text = label,
//                            color = if (index == selectedIndex) selectedTextColor else textColor,
//                            modifier = Modifier.align(Alignment.Center)
//                        )
//                    }
//                }
//            }
//        }
//    }
//
//}
//
//@Preview
//@Composable
//fun CustomTabsPreview() {
//    var selectedTabIndex by remember { mutableStateOf(1) }
//    CustomTabs(
//        labels = listOf("Label", "Label"),
//        selectedIndex = selectedTabIndex,
//        onValueChange = { newIndex ->
//            selectedTabIndex = newIndex
//        }
//    )
//}