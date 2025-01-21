package com.surivalcoding.composerecipeapp

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Modifier
import androidx.compose.ui.focus.focusModifier
import androidx.lifecycle.lifecycleScope
import com.surivalcoding.composerecipeapp.presentation.component.BigButton
import com.surivalcoding.composerecipeapp.presentation.component.IngredientItem
import com.surivalcoding.composerecipeapp.presentation.component.RecipeCardLoadingUI
import com.surivalcoding.composerecipeapp.presentation.component.SavedRecipesScreen
import com.surivalcoding.composerecipeapp.presentation.component.SavedRecipesState
import com.surivalcoding.composerecipeapp.presentation.component.signIn.SignInScreen
import com.surivalcoding.composerecipeapp.presentation.component.signUp.SignUpScreen
import com.surivalcoding.composerecipeapp.presentation.component.viewModel.RecipeViewModel
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val viewModel: RecipeViewModel by viewModels { RecipeViewModel.Factory }

        setContent {
            ComposeRecipeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var foodImages: List<String> = emptyList()
                    var titles: List<String> = emptyList()
                    var chefName: List<String> = emptyList()
                    var rates: List<Float> = emptyList()
                    var cookingTimeMinutes: List<Int> = emptyList()
                    lifecycleScope.launch {
                        foodImages = viewModel.getFoodImage()
                        titles = viewModel.getRecipeTitles()
                        chefName = viewModel.getChefNames()
                        rates = viewModel.getRatings()
                        cookingTimeMinutes = viewModel.getCookingTimes()
                    }

                    SavedRecipesScreen(
                        modifier = Modifier
                            .padding(innerPadding),
                        foodImage = foodImages,
                        titles = titles,
                        chefNames = chefName,
                        rates = rates,
                        cookingTimeMinutes = cookingTimeMinutes,
                        state = SavedRecipesState()
                    )
                }
            }
        }
    }
}

@Composable
fun test(
    modifier: Modifier = Modifier,
    paddingValues: PaddingValues,
    viewModel: RecipeViewModel
) {

}