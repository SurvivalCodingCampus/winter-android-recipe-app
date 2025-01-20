package com.surivalcoding.composerecipeapp

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
import androidx.compose.ui.Modifier
import com.surivalcoding.composerecipeapp.presentation.component.BigButton
import com.surivalcoding.composerecipeapp.presentation.component.IngredientItem
import com.surivalcoding.composerecipeapp.presentation.component.SavedRecipesScreen
import com.surivalcoding.composerecipeapp.presentation.component.signIn.SignInScreen
import com.surivalcoding.composerecipeapp.presentation.component.signUp.SignUpScreen
import com.surivalcoding.composerecipeapp.presentation.component.viewModel.RecipeViewModel
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val viewModel: RecipeViewModel by viewModels { RecipeViewModel.Factory }

        setContent {
            ComposeRecipeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SavedRecipesScreen(
                        modifier = Modifier
                            .padding(innerPadding),
                        foodImage = viewModel.getFoodImage(),
                        titles = viewModel.getRecipeTitles(),
                        chefNames = viewModel.getChefNames(),
                        rates = viewModel.getRatings(),
                        cookingTimeMinutes = viewModel.getCookingTimes()
                    )
                    /*SavedRecipesScreen(
                        modifier = Modifier
                            .padding(innerPadding),
                        titles = viewModel.getRecipeTitles()
                    )*/
                }
            }
        }
    }
}

@Composable
fun test(modifier: Modifier = Modifier, paddingValues: PaddingValues) {

}