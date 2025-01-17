package com.surivalcoding.composerecipeapp.presentation.component.dialog

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun FlowRatingDialog(
    title: String,
    actionName: String,
    starIndex: Int = 0,
    modifier: Modifier = Modifier,
    onDismissRequest: () -> Unit = {},
    onChange: (Int) -> Unit = {}
) {
    Dialog(
        onDismissRequest = { onDismissRequest() }
    ) {

        val emptyStarImage = painterResource(R.drawable.star_empty)
        val fillStarImage = painterResource(R.drawable.star_fill)


        Card(
            modifier = modifier
                .width(170.dp),
            colors = CardDefaults.cardColors(
                containerColor = AppColors.white
            ),
            shape = RoundedCornerShape(8.dp)
        ) {
            Column(
                modifier = Modifier.fillMaxWidth(),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Spacer(Modifier.height(10.dp))
                Text(
                    title, style = AppTextStyles.smallTextRegular.copy(
                        color = AppColors.label_color
                    )
                )

                Spacer(modifier = Modifier.height(5.dp))

                Row(
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp)
                ) {
                    repeat(5) { index ->
                        Image(
                            painter = if (index < starIndex) fillStarImage else emptyStarImage,
                            contentDescription = null,
                            modifier = Modifier
                                .weight(1f)
                                .padding(horizontal = 2.dp)
                                .clickable {
                                    // 선택된 개수를 콜백으로 반환 (인덱스 + 1)
                                    onChange(index + 1)
                                },
                        )
                    }

                }
                Spacer(modifier = Modifier.height(5.dp))

                Box(
                    modifier = Modifier
                        .background(
                            color = if (starIndex > 0) AppColors.rating else AppColors.gray_4,
                            shape = RoundedCornerShape(6.dp)
                        )
                        .clickable(enabled = starIndex > 0) {
                            println("점수 리턴 $starIndex")
                        }
                        .padding(vertical = 4.dp, horizontal = 20.dp)
                ) {
                    Text(
                        text = actionName, style = AppTextStyles.smallTextRegular.copy(
                            fontSize = 8.sp, color = AppColors.white
                        )
                    )
                }

                Spacer(modifier = Modifier.height(10.dp))

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun FlowRatingDialogPreview() {
    // 별 채워짐 상태 변수
    var starIndex by remember { mutableIntStateOf(0) }
    FlowRatingDialog(title = "Rate recipe", actionName = "Send", starIndex = starIndex, onChange = { index ->
        starIndex = index
    }, onDismissRequest = {
        println("다이얼로그 종료 해버리깅!!")
    })
}

