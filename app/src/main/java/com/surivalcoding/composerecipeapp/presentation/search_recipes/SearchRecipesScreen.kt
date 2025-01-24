package com.surivalcoding.composerecipeapp.presentation.search_recipes

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.aspectRatio
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.heightIn
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ModalBottomSheet
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.rememberModalBottomSheetState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.dotlottie.dlplayer.Mode
import com.lottiefiles.dotlottie.core.compose.ui.DotLottieAnimation
import com.lottiefiles.dotlottie.core.util.DotLottieSource
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.domain.model.Recipe
import com.surivalcoding.composerecipeapp.domain.model.enums.TimeFilter
import com.surivalcoding.composerecipeapp.presentation.component.InputField
import com.surivalcoding.composerecipeapp.presentation.component.filter_bottomsheet.FilterBottomSheet
import com.surivalcoding.composerecipeapp.presentation.component.filter_bottomsheet.FilterState
import com.surivalcoding.composerecipeapp.ui.AppColors
import com.surivalcoding.composerecipeapp.ui.AppTextStyles

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchRecipesScreen(
    modifier: Modifier = Modifier,
    state: SearchRecipesState = SearchRecipesState(),
    onQueryChange: (String) -> Unit = {},
    onDismiss: () -> Unit,
) {
    var showBottomSheet by remember { mutableStateOf(false) }
    val sheetState = rememberModalBottomSheetState()

    // 필터 상태
    var filterState by remember { mutableStateOf(FilterState()) }

    // 필터 변경 함수
    val onTimeFilterChange: (TimeFilter) -> Unit = { filterState = filterState.copy(timeFilter = it) }
    val onRateFilterChange: (Int?) -> Unit = { filterState = filterState.copy(rateFilter = it) }
    val onCategoryFilterChange: (String?) -> Unit = { filterState = filterState.copy(categoryFilter = it) }

    Scaffold { innerPadding ->
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(innerPadding)
                .padding(horizontal = 30.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                text = "Search recipes",
                style = AppTextStyles.mediumTextBold,
                modifier = Modifier.padding(vertical = 17.dp)
            )

            Row(
                modifier = Modifier.fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                InputField(
                    label = "",
                    value = state.query,
                    placeholder = "Search recipe",
                    leadingIcon = {
                        Image(
                            painter = painterResource(R.drawable.search),
                            contentDescription = "Search",
                            modifier = Modifier.size(18.dp)
                        )
                    },
                    onValueChange = onQueryChange,
                    modifier = Modifier
                        .weight(1f)
                        .padding(end = 20.dp)
                )

                Box(
                    modifier = Modifier
                        .size(40.dp)
                        .background(
                            color = AppColors.primary100,
                            shape = RoundedCornerShape(10.dp)
                        )
                        .clickable { showBottomSheet = true },
                    contentAlignment = Alignment.Center
                ) {
                    Image(
                        painter = painterResource(R.drawable.filter),
                        contentDescription = "Filter",
                        modifier = Modifier.size(20.dp)
                    )
                }
            }

            // Modal Bottom Sheet 처리
            if (showBottomSheet) {
                FilterBottomSheet(
                    onDismiss = { showBottomSheet = false },
                    state = filterState,
                    onTimeFilterChange = onTimeFilterChange,
                    onRateFilterChange = onRateFilterChange,
                    onCategoryFilterChange = onCategoryFilterChange,
                    onFilterApply = {
                        showBottomSheet = false
                        // 필터 적용 로직
                    }
                )
            }


            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(vertical = 20.dp),
                horizontalArrangement = Arrangement.SpaceBetween,
                verticalAlignment = Alignment.CenterVertically
            ) {
                Text(
                    text = state.resultTitle,
                    style = AppTextStyles.normalTextBold
                )
                Text(
                    text = "${state.filteredRecipes.size} results",
                    style = AppTextStyles.smallerTextRegular,
                    color = AppColors.gray3
                )
            }

            when {
                state.isLoading -> {
                    DotLottieAnimation(
                        source = DotLottieSource.Url("https://lottie.host/bb71f4a6-1af3-4f94-8fc1-534aae11ef23/CHz2ZvcxYN.lottie"),
                        autoplay = true,
                        loop = true,
                        speed = 3f,
                        useFrameInterpolation = false,
                        playMode = Mode.FORWARD,
                        modifier = Modifier
                            .size(400.dp)
                    )
                }

                else -> {
                    if (state.filteredRecipes.isNotEmpty()) {
                        LazyVerticalGrid(
                            columns = GridCells.Fixed(2),
                            horizontalArrangement = Arrangement.spacedBy(15.dp),
                            verticalArrangement = Arrangement.spacedBy(15.dp),
                        ) {
                            items(
                                count = state.filteredRecipes.size,
                                key = { index -> state.filteredRecipes[index].id }
                            ) { index ->
                                val recipe = state.filteredRecipes[index]
                                SearchRecipeCard(
                                    recipe = recipe,
                                    modifier = Modifier.fillMaxWidth()
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
private fun SearchRecipeCard(
    recipe: Recipe,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .aspectRatio(1f),
        shape = RoundedCornerShape(10.dp)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {
            AsyncImage(
                model = recipe.image,
                contentDescription = recipe.name,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )

            // 그라데이션 오버레이
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black.copy(alpha = 0.7f)
                            )
                        )
                    )
            )

            // 텍스트 내용
            Column(
                modifier = Modifier
                    .align(Alignment.BottomStart)
                    .padding(12.dp)
            ) {
                Text(
                    text = recipe.name,
                    style = AppTextStyles.smallTextBold,
                    color = Color.White,
                    maxLines = 2,
                    overflow = TextOverflow.Ellipsis
                )
                Text(
                    text = "By ${recipe.chef}",
                    style = AppTextStyles.smallerTextRegular,
                    color = AppColors.gray4
                )
            }
        }
    }
}