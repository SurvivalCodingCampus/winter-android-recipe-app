package com.surivalcoding.composerecipeapp.ui.screen

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.surivalcoding.composerecipeapp.R
import com.surivalcoding.composerecipeapp.ui.component.FilterButton
import com.surivalcoding.composerecipeapp.ui.component.SearchField
import com.surivalcoding.composerecipeapp.ui.component.SearchRecipeCard
import com.surivalcoding.composerecipeapp.ui.theme.Black
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme
import com.surivalcoding.composerecipeapp.ui.theme.Gray3
import com.surivalcoding.composerecipeapp.ui.theme.PoppinsBoldTypography
import com.surivalcoding.composerecipeapp.ui.theme.PoppinsRegularTypography
import com.surivalcoding.composerecipeapp.ui.theme.Primary80
import com.surivalcoding.composerecipeapp.ui.viewmodel.SearchRecipesViewModel

@Composable
fun SearchRecipesScreen(
    viewModel: SearchRecipesViewModel = hiltViewModel()
) {
    val state = viewModel.searchState.collectAsStateWithLifecycle()

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp, bottom = 10.dp, start = 30.dp, end = 30.dp)
                .align(Alignment.CenterHorizontally)
        ) {
            Icon(
                modifier = Modifier
                    .align(Alignment.CenterStart),
                painter = painterResource(R.drawable.ic_arrow_left),
                contentDescription = "Back",
                tint = Black,
            )
            Box(
                modifier = Modifier
                    .align(Alignment.Center),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    modifier = Modifier,
                    text = "Search recipes",
                    style = PoppinsBoldTypography.bodyLarge
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 6.dp, start = 30.dp, end = 30.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(20.dp)
        ) {
            SearchField(
                modifier = Modifier
                    .weight(1f),
                value = state.value.query,
                onValueChange = {
                    viewModel.updateSearchQuery(it)
                }
            )

            FilterButton()
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 30.dp, vertical = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Text(
                text = "Recent Search",
                style = PoppinsBoldTypography.bodyLarge
            )

            Text(
                modifier = Modifier,
                text = "${state.value.filteredRecipes.size} results",
                style = PoppinsRegularTypography.bodySmall.copy(
                    color = Gray3
                ),
            )
        }

        if (state.value.isLoading) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
            ) {
                CircularProgressIndicator(
                    modifier = Modifier
                        .align(Alignment.Center),
                    color = Primary80
                )
            }
        } else {
            LazyVerticalGrid(
                columns = GridCells.Fixed(2),
                modifier = Modifier
                    .padding(30.dp, 10.dp),
                horizontalArrangement = Arrangement.spacedBy(15.dp),
                verticalArrangement = Arrangement.spacedBy(15.dp)
            ) {
                items(state.value.filteredRecipes.size) { i ->
                    val filteredRecipes = state.value.filteredRecipes
                    SearchRecipeCard(
                        imageUrl = filteredRecipes[i].thumbnailUrl,
                        title = filteredRecipes[i].title,
                        chefName = filteredRecipes[i].chefName,
                        rating = filteredRecipes[i].rating.toString(),
                        cookTime = filteredRecipes[i].cookingMinute.toString()
                    )
                }
            }
        }
    }
}

@Preview(
    showBackground = true
)
@Composable
fun SearchRecipesScreenPreview() {
    ComposeRecipeAppTheme {
        SearchRecipesScreen()
    }
}