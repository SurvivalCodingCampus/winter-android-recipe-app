package com.surivalcoding.composerecipeapp.presentation.searchrecipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.surivalcoding.composerecipeapp.data.mock.fakeSearchRecipe
import com.surivalcoding.composerecipeapp.data.model.SearchRecipe
import com.surivalcoding.composerecipeapp.ui.AppIcons
import com.surivalcoding.composerecipeapp.ui.component.FilterSearchBottomSheet
import com.surivalcoding.composerecipeapp.ui.component.SearchField
import com.surivalcoding.composerecipeapp.ui.component.SquareRecipeCard
import com.surivalcoding.composerecipeapp.ui.custom.LoadingWheel
import com.surivalcoding.composerecipeapp.ui.custom.NoPaddingButton
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun SearchRecipeScreen(
    modifier: Modifier = Modifier,
    searchRecipeViewModel: SearchRecipeViewModel = hiltViewModel()
) {
    val searchRecipeUiState by searchRecipeViewModel.searchRecipeUiState.collectAsStateWithLifecycle()
    val searchQuery by searchRecipeViewModel.searchQuery.collectAsStateWithLifecycle()
    SearchRecipeScreen(
        title = "Search Recipe",
        query = searchQuery,
        searchRecipeUiState = searchRecipeUiState,
        onFilterClick = {},
        onQueryChange = searchRecipeViewModel::onSearchQueryChanged,
        modifier = modifier
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SearchRecipeScreen(
    title: String,
    searchRecipeUiState: SearchRecipeUiState,
    onFilterClick: () -> Unit,
    onQueryChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    query: String = ""
) {
    var showBottomSheet by remember { mutableStateOf(false) }
    Box {
        Column(
            modifier = modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = title,
                        style = AppTextStyles.mediumTextSemiBold
                    )
                },
                navigationIcon = {
                    Icon(
                        imageVector = AppIcons.ArrowBack,
                        contentDescription = "Back"
                    )
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Transparent
                ),
                windowInsets = WindowInsets(0, 0, 0, 0),
                expandedHeight = 27.dp,
                modifier = Modifier.padding(top = 54.dp, bottom = 20.dp)
            )

            SearchField(
                query = query,
                onQueryChange = onQueryChange,
                onFilterClick = {
                    showBottomSheet = true
                },
                modifier = Modifier.padding(bottom = 20.dp)
            )

            when (searchRecipeUiState) {
                SearchRecipeUiState.LoadFailed -> {}
                SearchRecipeUiState.Loading -> {
                    Box(
                        contentAlignment = Alignment.Center,
                        modifier = Modifier
                            .fillMaxWidth()
                            .fillMaxHeight(0.8f)
                    ) {
                        LoadingWheel(
                            contentDescription = "Saved Recipes 불러오는 중",
                            modifier = Modifier.size(120.dp)
                        )
                    }
                }

                is SearchRecipeUiState.EmptyQuery -> {
                    RecentRecipeResultBody(
                        searchRecipeUiState.recentRecipes,
                        modifier = Modifier.fillMaxWidth()
                    )
                }

                is SearchRecipeUiState.Success -> {
                    if (searchRecipeUiState.isEmpty()) {
                        EmptySearchResultBody(
                            query = query,
                            message = "Sorry, there is no recipe found for your search",
                            modifier = Modifier.padding(vertical = 24.dp),
                        )
                    } else {
                        SearchRecipeResultBody(
                            searchRecipes = searchRecipeUiState.searchRecipes,
                            modifier = Modifier.fillMaxWidth()
                        )
                    }
                }
            }
        }
        if (showBottomSheet) {
            FilterSearchBottomSheet(
                onDismissRequest = { showBottomSheet = false },
                onFilterClick = {
                    showBottomSheet = false
                }
            )
        }
    }
}

@Composable
fun SearchField(
    query: String = "",
    onQueryChange: (String) -> Unit = {},
    onFilterClick: () -> Unit = {},
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
) {
    Row(
        modifier = modifier
    ) {
        SearchField(
            value = query,
            onValueChange = onQueryChange,
            enabled = enabled,
            modifier = Modifier.weight(1f)
        )
        Spacer(Modifier.width(20.dp))
        NoPaddingButton(
            onClick = onFilterClick,
            shape = RoundedCornerShape(10.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(AppIcons.outlinedSetting),
                contentDescription = "Search setting",
                modifier = Modifier.padding(10.dp)
            )
        }
    }
}

@Composable
private fun RecentRecipeResultBody(
    recentRecipes: List<SearchRecipe>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Text(
            text = "Recent Search",
            style = AppTextStyles.mediumTextSemiBold,
            modifier = Modifier.padding(vertical = 20.dp)
        )

        SearchResultGrid(recentRecipes)
    }
}

@Composable
private fun SearchRecipeResultBody(
    searchRecipes: List<SearchRecipe>,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier
    ) {
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
        ) {
            Text(
                text = "Search Result",
                style = AppTextStyles.mediumTextSemiBold,
            )
            Text(
                text = "${searchRecipes.size} results",
                style = AppTextStyles.smallerTextRegular,
                color = AppColors.Gray3
            )
        }

        SearchResultGrid(searchRecipes)
    }
}

@Composable
private fun EmptySearchResultBody(
    message: String,
    query: String,
    modifier: Modifier = Modifier
) {
    val annotatedMessage = AnnotatedString(
        text = "$message \"$query\"",
        spanStyles = listOf(
            AnnotatedString.Range(
                SpanStyle(color = AppColors.Primary100),
                start = message.length,
                end = message.length + query.length + 2
            )
        )
    )
    Text(
        text = annotatedMessage,
        style = AppTextStyles.mediumTextRegular,
        textAlign = TextAlign.Center,
        modifier = modifier
    )
}

@Composable
private fun SearchResultGrid(
    searchRecipes: List<SearchRecipe>,
    modifier: Modifier = Modifier
) {
    LazyVerticalGrid(
        columns = GridCells.Fixed(2),
        verticalArrangement = Arrangement.spacedBy(15.dp),
        horizontalArrangement = Arrangement.spacedBy(15.dp),
        modifier = modifier,
    ) {
        items(searchRecipes) { searchRecipe ->
            SquareRecipeCard(
                searchRecipe = searchRecipe,
                contentDescription = searchRecipe.title
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun SearchRecipeScreenPreview() {
    ComposeRecipeAppTheme {
        SearchRecipeScreen(
            title = "Search Recipe",
            query = "",
            searchRecipeUiState = SearchRecipeUiState.Success(fakeSearchRecipe),
            onFilterClick = {},
            onQueryChange = {}
        )
    }
}