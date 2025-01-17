import androidx.compose.runtime.Composable
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp

// Figma의 375px width 기준으로 변환 비율 계산
val FIGMA_SCREEN_WIDTH = 375f

@Composable
fun getFigmaToAndroidRatio(): Float {
    val screenWidth = LocalConfiguration.current.screenWidthDp
    return screenWidth / FIGMA_SCREEN_WIDTH
}

// dp 변환 함수
@Composable
fun figmaToDp(figmaPx: Int): Dp {
    return (figmaPx * getFigmaToAndroidRatio()).dp
}

