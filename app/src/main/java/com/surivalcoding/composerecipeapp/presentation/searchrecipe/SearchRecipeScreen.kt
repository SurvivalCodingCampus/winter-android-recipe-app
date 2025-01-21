package com.surivalcoding.composerecipeapp.presentation.searchrecipe

import android.util.Log
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.BasicTextField
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.rememberUpdatedState
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.presentation.item.RecipeListGrid
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles


@Composable
fun SearchRecipeScreen(
    viewModel: SearchRecipeViewModel
) {
    val backImage = painterResource(R.drawable.arrow_left)
    val searchIcon = painterResource(R.drawable.search)
    val filterIcon = painterResource(R.drawable.setting_4)
    val recipeList by viewModel.searchRecipeState.collectAsStateWithLifecycle()

    val (value, onValueChange) = rememberSaveable { mutableStateOf("") }

    // rememberUpdatedState: LaunchedEffect나 SideEffect내에서 같은값을 참조할경우 컴포지션이 다시 실행되기 전의 값일 수 있기때문에 컴포지션을 실행한 후에도 최신 상태값을 유지할수 있도록 함
    val filterText = rememberUpdatedState(value)
    LaunchedEffect(filterText.value) {
        Log.e("컴포즈", "런치드 이펙트 발동! $value")
        viewModel.filterRecipeList(filterText.value)
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(start = 30.dp, end = 30.dp, top = 10.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Image(
                painter = backImage,
                contentDescription = "back",
                modifier = Modifier.size(20.dp)
            )

            Spacer(modifier = Modifier.width(69.dp))

            Text(
                text = "Search recipes",
                style = AppTextStyles.mediumTextSemiBold.copy(
                    color = AppColors.label_color,
                    fontSize = 18.sp
                )
            )
        }

        Spacer(modifier = Modifier.height(17.dp))

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(40.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            BasicTextField(
                value = value,
                onValueChange = { onValueChange(it) },
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight(),
                textStyle = AppTextStyles.smallTextRegular.copy(
                    fontSize = 11.sp,
                    color = AppColors.black
                ),
                keyboardOptions = KeyboardOptions.Default.copy(
                    imeAction = ImeAction.Search
                ),
                decorationBox = { innerTextField ->
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .background(color = AppColors.white)
                            .border(1.dp, color = AppColors.gray_4, shape = RoundedCornerShape(10.dp))
                            .padding(horizontal = 10.dp),
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        Icon(
                            painter = searchIcon,
                            contentDescription = "search",
                            modifier = Modifier.size(18.dp),
                            tint = AppColors.gray_4
                        )

                        Spacer(modifier = Modifier.width(width = 8.dp))

                        // 커서 위치로 인해 Box로 래핑
                        Box {
                            // 기본적으로 placeHolder를 지원하지 않아 직접 구현을 해줘야함
                            if (value.isBlank()) {
                                Text(
                                    text = "Search recipe",
                                    style = AppTextStyles.smallTextRegular.copy(
                                        fontSize = 11.sp,
                                        color = AppColors.gray_4
                                    )
                                )
                            }

                            innerTextField()
                        }
                    }
                }
            )

            // 필터 아이콘
            Box(
                modifier = Modifier
                    .size(40.dp)
                    .background(AppColors.primary_100, shape = RoundedCornerShape(10.dp))
            ) {
                Image(
                    modifier = Modifier.align(Alignment.Center),
                    painter = filterIcon,
                    contentDescription = null
                )
            }
        }

        Spacer(Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = if (value.isBlank()) "Recent Search" else "Search Result",
                style = AppTextStyles.mediumTextSemiBold.copy(
                    fontSize = 16.sp,
                    color = AppColors.black
                )
            )

            Spacer(Modifier.weight(1f))

            Text(
                text = "${recipeList.recipeList.size} results",
                style = AppTextStyles.smallTextRegular.copy(
                    fontSize = 11.sp,
                    color = AppColors.gray_3
                )
            )
        }

        Spacer(modifier = Modifier.height(20.dp))

        RecipeListGrid(recipeList.recipeList)
    }
}
