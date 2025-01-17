package com.surivalcoding.composerecipeapp.presentation.component.global.label

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.wear.compose.material3.placeholder
import androidx.wear.compose.material3.placeholderShimmer
import androidx.wear.compose.material3.rememberPlaceholderState
import com.surivalcoding.composerecipeapp.ui.AppColors


@Composable
fun Label(
    text: String = "Label",
    value: String = "value",
    placeholder: String = "placeHolder",
    onValueChange: (String) -> Unit = {}
) {
    var labelText by remember { mutableStateOf("") }
    val chipPlaceholderState = rememberPlaceholderState { labelText.isNotEmpty() }

    Box(
        modifier = Modifier
            .fillMaxWidth()
//            .background(color = Color.Red)
        ,
        contentAlignment = Alignment.Center

    ) {
        Column(
            modifier = Modifier
                .fillMaxWidth(),

            verticalArrangement = Arrangement.spacedBy(10.dp),
            horizontalAlignment = Alignment.Start
        ) {
            Text(text = "hello")
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .border(1.5.dp, AppColors.Primary100, shape = RoundedCornerShape(size = 10.dp))
//                    .background(color = Color.Transparent, shape = RoundedCornerShape(size = 10.dp))
                    .padding(start = 10.dp, top = 19.dp, bottom = 19.dp),
                contentAlignment = Alignment.CenterStart,

                ) {
                Text(
                    text = labelText,
                    overflow = TextOverflow.Ellipsis,
                    modifier = Modifier
                        .fillMaxWidth()
                        .placeholderShimmer(chipPlaceholderState)
                        .placeholder(
                            placeholderState = chipPlaceholderState,
                        ),
                )
            }
        }
    }


}

@Composable
@Preview(showBackground = true)
fun LabelPreview() {
    Label(
        text = "Label",
        value = "",
        placeholder = "password",
        onValueChange = {}
    )
}



