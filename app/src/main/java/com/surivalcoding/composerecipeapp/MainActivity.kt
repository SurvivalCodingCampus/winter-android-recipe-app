package com.surivalcoding.composerecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.surivalcoding.composerecipeapp.navigation.MyApp
import com.surivalcoding.composerecipeapp.presentation.savedrecipe.RecipeViewModel
import com.surivalcoding.composerecipeapp.presentation.searchrecipe.SearchRecipeViewModel
import com.surivalcoding.composerecipeapp.presentation.searchrecipe.SearchRecipeScreen

class MainActivity : ComponentActivity() {

    private val recipeViewModel: RecipeViewModel by viewModels { RecipeViewModel.Factory }
    private val searchRecipeViewModel: SearchRecipeViewModel by viewModels { SearchRecipeViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            MyApp()
        }
    }
}





