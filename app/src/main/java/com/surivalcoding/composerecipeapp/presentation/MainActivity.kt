package com.surivalcoding.composerecipeapp.presentation

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.surivalcoding.composerecipeapp.data.viewmodel.RecipeViewModel
import com.surivalcoding.composerecipeapp.presentation.page.SavedRecipeScreen

class MainActivity : ComponentActivity() {

    private val recipeViewModel: RecipeViewModel by viewModels { RecipeViewModel.Factory }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
            SavedRecipeScreen(recipeViewModel)
        }
    }
}





