package com.surivalcoding.composerecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.rememberNavController
import com.surivalcoding.composerecipeapp.presentation.NavigationRoot
import com.surivalcoding.composerecipeapp.presentation.saved_recipe_screen.SavedRecipeViewModel
import com.surivalcoding.composerecipeapp.presentation.search_recipes_screen.SearchRecipeViewModel
import dagger.hilt.android.AndroidEntryPoint
import dagger.hilt.android.lifecycle.HiltViewModel
import org.koin.compose.viewmodel.koinViewModel

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val navController = rememberNavController()

            // viewModels 구글 제공, viewModel 컴포즈 제공
//            val savedRecipeViewModel: SavedRecipeViewModel = viewModel(
//                factory = SavedRecipeViewModel.Factory
//            )

            // koin viewModel
//            val savedRecipeViewModel: SavedRecipeViewModel = koinViewModel()

            // Hilt viewModel
            val savedRecipeViewModel: SavedRecipeViewModel = hiltViewModel()
            val searchRecipeViewModel: SearchRecipeViewModel = hiltViewModel()

            val savedRecipeState by savedRecipeViewModel.state.collectAsStateWithLifecycle()

            NavigationRoot(
                navController = navController,
                savedRecipeState = savedRecipeState,
                onBookmarkClick = { savedRecipeViewModel.cancelBookmark(it) }
            )
        }
    }
}




//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
////        val viewModels: SavedRecipeViewModel by viewModels{
////            SavedRecipeViewModel.Factory
////        }
//
//        setContent {
//            val viewModel: SavedRecipeViewModel = viewModel(
//                factory = SavedRecipeViewModel.Factory
//            )
//
//            val state = viewModel.state.collectAsStateWithLifecycle()
//
//            SavedRecipesScreen(
//                modifier = Modifier.fillMaxSize(),
//                state = state.value,
//                waitSavedRecipes = { viewModel.waitSavedRecipes() }
//            )
//        }
//    }
//}

//class MainActivity : ComponentActivity() {
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//
////        val viewModels: SavedRecipeViewModel by viewModels{
////            SavedRecipeViewModel.Factory
////        }
//
//        setContent {
//            val viewModel: SearchRecipeViewModel = viewModel(
//                factory = SearchRecipeViewModel.Factory
//            )
//
//            val state by viewModel.state.collectAsStateWithLifecycle()
//
//            SearchRecipesScreen(
//                modifier = Modifier.fillMaxSize(),
//                state = state,
//                waitSavedRecipes = { viewModel.waitSearchRecipes() },
//                onValueChange = { viewModel.onSearchQueryChanged(it) }
//            )
//        }
//    }
//}