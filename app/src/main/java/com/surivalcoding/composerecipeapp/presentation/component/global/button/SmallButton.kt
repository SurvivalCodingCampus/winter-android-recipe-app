
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.surivalcoding.composerecipeapp.presentation.component.global.button.BaseButton
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@Composable
fun SmallButton(
    modifier: Modifier = Modifier,
    text: String,
) {
    BaseButton(
        modifier = modifier,
        width = 174.dp,
        height = 37.dp,
        text = text,
        iconSize = 0.dp,
        fontStyle = AppTextStyles.regularNormal.copy(
            fontSize = 11.sp
        ),
        onClick = {}
    )
}

