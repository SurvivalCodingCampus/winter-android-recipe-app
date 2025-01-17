import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.gestures.draggable
import androidx.compose.foundation.gestures.rememberDraggableState
import androidx.compose.foundation.interaction.DragInteraction
import androidx.compose.foundation.interaction.Interaction
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.BoxWithConstraints
import androidx.compose.foundation.layout.Column
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
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalOf
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.presentation.component.button.BaseButton
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun CustomRateIcon() {


}

@Composable
fun RatingDialog(
    text: String? = "Rate recipe",
    rate: Int = 0,
    onChange: (Int) -> Unit = {}
) {

    val interactionSource = remember { MutableInteractionSource() }
    val interactions = remember { mutableStateListOf<Interaction>() }

    val starRating by remember { mutableIntStateOf(rate) }


    BoxWithConstraints(modifier = Modifier) {
        val containerWidth = maxWidth * 0.5f  // 50% 크기
        Text("$containerWidth")
    }



    Box(
        modifier = Modifier
            .shadow(
                elevation = 10.dp,
                spotColor = Color(0x1A000000),
                ambientColor = Color(0x1A000000)
            )
            .shadow(
                elevation = 2.dp,
                spotColor = Color(0x33000000),
                ambientColor = Color(0x33000000)
            )
            .padding(1.dp)
            .width(170.dp)
            .height(91.dp)
            .background(color = Color(0xFFFFFFFF), shape = RoundedCornerShape(size = 8.dp))
            .padding(start = 15.dp, top = 10.dp, end = 15.dp, bottom = 10.dp),
        contentAlignment = Alignment.Center
    ) {
        Column(
            modifier = Modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(5.dp)
        ) {
            Text(text ?: "", modifier = Modifier)

            Row(
                horizontalArrangement = Arrangement.spacedBy(5.dp),

            ) {
                repeat(5) { index ->
                    Box(
                        modifier = Modifier,
//                            .draggable(
//                                state = rememberDraggableState { delta ->
//                                    offsetX += delta // 드래그 변화량 적용
//                                },
//                                orientation = Orientation.Horizontal, // 수평 드래그
//                                enabled = true, // 드래그 활성화
//                                startDragImmediately = false, // 즉시 드래그 시작 비활성화
//                                onDragStarted = {
//                                    println("Drag started at: $it")
//                                },
//                                onDragStopped = {
//                                    println("Drag stopped. Final offset: $offsetX")
//                                }
//                            )
                    ) {
                        Icon(
                            imageVector = if (index < rate) Icons.Filled.StarRate else Icons.Outlined.StarRate,
                            contentDescription = "rating",
                            modifier = Modifier
                                .size(18.dp),
                            tint = Color(0xFFFFA500)
                        )
                    }
                }
            }

            BaseButton(
                modifier = Modifier.background(
                    shape = RoundedCornerShape(size = 6.dp),
                    color = AppColors.Secondary100
                ),
                width = 61.dp,
                height = 20.dp,
                text = "Send",
                fontStyle = AppTextStyles.regularSmall.copy(
                    fontSize = 8.sp
                ),
                iconSize = 10.dp,
                color = AppColors.Secondary100,
                enabled = rate < 1,
                onClick = {}
            )

        }

    }

}


@Preview(showBackground = true)
@Composable
fun RatingDialogPreview() {
    var starRating by remember { mutableIntStateOf(0) }

    Row() {
        RatingDialog(rate = starRating, onChange = { rate -> starRating = rate + 1 })
        Text("Str rating : ${starRating}")
    }
}
