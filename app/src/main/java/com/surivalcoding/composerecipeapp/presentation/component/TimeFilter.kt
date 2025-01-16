package com.surivalcoding.composerecipeapp.presentation.component

//@Composable
//fun TimeFilter(
//    selectedIndex: Int,
//    onChangeSelected: (Int) -> Unit,
//) {
//    var selectIdx by remember { mutableIntStateOf(0) }
//    val list = listOf("All", "Newest", "Oldest", "Popularity")
//
//    Row {
//        list.forEachIndexed { index, label ->
//            FilterButton(
//                label = label,
//                selected = index == selectedIndex,
//                onClick = {
//                    onChangeSelected(index)
//                }
//            )
//        }
//    }
//}
//
//@Preview
//@Composable
//private fun TimeFilterPreview() {
//    ComposeRecipeAppTheme {
//        TimeFilter(
//
//        )
//    }
//}