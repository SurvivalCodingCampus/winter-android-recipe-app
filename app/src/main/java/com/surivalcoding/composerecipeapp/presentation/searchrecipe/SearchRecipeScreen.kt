package com.surivalcoding.composerecipeapp.presentation.searchrecipe

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
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
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import com.surivalcoding.composerecipeapp.data.mock.fakeSearchRecipe
import com.surivalcoding.composerecipeapp.presentation.component.SearchField
import com.surivalcoding.composerecipeapp.presentation.component.SquareRecipeCard
import com.surivalcoding.composerecipeapp.ui.CraIcons
import com.surivalcoding.composerecipeapp.ui.component.LoadingWheel
import com.surivalcoding.composerecipeapp.ui.component.NoPaddingButton
import com.surivalcoding.composerecipeapp.ui.theme.AppColors
import com.surivalcoding.composerecipeapp.ui.theme.AppTextStyles
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

@Composable
fun SearchRecipeScreen(
    modifier: Modifier = Modifier,
    searchRecipeViewModel: SearchRecipeViewModel = viewModel(factory = SearchRecipeViewModel.Factory)
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
                    imageVector = CraIcons.ArrowBack,
                    contentDescription = "Back"
                )
            },
            colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                containerColor = Color.Transparent
            ),
            expandedHeight = 27.dp,
            modifier = Modifier.padding(vertical = 20.dp)
        )

        SearchField(
            query = query,
            onQueryChange = onQueryChange,
            onFilterClick = onFilterClick,
            modifier = Modifier.padding(bottom = 20.dp)
        )

        when (searchRecipeUiState) {
            SearchRecipeUiState.EmptyQuery -> {}
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


            is SearchRecipeUiState.Success -> {
                if (searchRecipeUiState.isEmpty()) {
                    val message = """Sorry, there is no recipe found for your search "$query""""
                    val start = message.indexOf(query)
                    Text(
                        text = AnnotatedString(
                            text = message,
                            spanStyles = listOf(
                                AnnotatedString.Range(
                                    SpanStyle(color = AppColors.Primary100),
                                    start = start,
                                    end = start + query.length,
                                ),
                            ),
                        ),
                        style = AppTextStyles.mediumTextRegular,
                        textAlign = TextAlign.Center,
                        modifier = Modifier.padding(vertical = 24.dp),
                    )
                } else {
                    Text(
                        text = if (query.isBlank()) "Recent Search" else "Search Result",
                        style = AppTextStyles.mediumTextSemiBold,
                        modifier = Modifier.padding(vertical = 20.dp)
                    )

                    LazyVerticalGrid(
                        columns = GridCells.Fixed(2),
                        verticalArrangement = Arrangement.spacedBy(15.dp),
                        horizontalArrangement = Arrangement.spacedBy(15.dp)
                    ) {
                        items(searchRecipeUiState.recipes) { searchRecipe ->
                            SquareRecipeCard(
                                searchRecipe = searchRecipe,
                                contentDescription = searchRecipe.title
                            )
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun SearchField(
    query: String,
    onQueryChange: (String) -> Unit,
    onFilterClick: () -> Unit,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier
    ) {
        SearchField(
            value = query,
            onValueChange = onQueryChange,
            modifier = Modifier.weight(1f)
        )
        Spacer(Modifier.width(20.dp))
        NoPaddingButton(
            onClick = onFilterClick,
            shape = RoundedCornerShape(10.dp)
        ) {
            Icon(
                imageVector = ImageVector.vectorResource(CraIcons.outlinedSetting),
                contentDescription = "Search setting",
                modifier = Modifier.padding(10.dp)
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