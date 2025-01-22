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
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.lifecycle.lifecycleScope
import com.surivalcoding.composerecipeapp.presentation.component.SavedRecipesScreen
import com.surivalcoding.composerecipeapp.presentation.component.SearchRecipeScreen
import com.surivalcoding.composerecipeapp.presentation.component.viewModel.RecipeViewModel
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    @SuppressLint("StateFlowValueCalledInComposition", "CoroutineCreationDuringComposition")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()

        val viewModel: RecipeViewModel by viewModels { RecipeViewModel.Factory }

        setContent {
            ComposeRecipeAppTheme {
                var typing by remember { mutableStateOf(TextFieldValue("")) }

                lifecycleScope.launch {
                    viewModel.injectRecipeDataToState()
                }
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    SearchRecipeScreen(
                        modifier = Modifier
                            .padding(innerPadding),
                        typing = typing,
                        onValueChanged = { newText ->
                            if(newText.text == "") {
                                viewModel.endSearching()
                            } else {
                                viewModel.startSearching()
                            }
                            lifecycleScope.launch {
                                viewModel.onInputTextChanged(newText)
                            }
                            typing = newText
                        },
                        state = viewModel.state.collectAsState()
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

/*
// SavedRecipesScreen 사용 예제
lifecycleScope.launch {
                        viewModel.injectRecipeDataToState()
                    }
                    SavedRecipesScreen(
                        modifier = Modifier
                            .padding(innerPadding),

                        state = viewModel.state.collectAsState()
                    )
                    /*SavedRecipesScreen(
                        modifier = Modifier
                            .padding(innerPadding),
                        foodImage = viewModel.state.value.foodImages,
                        titles = viewModel.state.value.titles,
                        chefNames = viewModel.state.value.chefNames,
                        rates = viewModel.state.value.rates,
                        cookingTimeMinutes = viewModel.state.value.cookingTimeMinutes,
                        dataCount = viewModel.state.value.dataCount,
                        state = viewModel.state.collectAsState()
                    )*/
                    /*SavedRecipesScreen(
                        modifier = Modifier
                            .padding(innerPadding),
                        foodImage = viewModel.getFoodImage(),
                        titles = viewModel.getRecipeTitles(),
                        chefNames = viewModel.getChefNames(),
                        rates = viewModel.getRatings(),
                        cookingTimeMinutes = viewModel.getCookingTimes(),
                        dataCount = viewModel.getDataCount(),
                        state = viewModel.state.collectAsState()
                    )*/
 */

/*
// SearchRecipeScreen 사용 예제
SearchRecipeScreen(
                        modifier = Modifier
                            .padding(innerPadding),
                        typing = typing,
                        onValueChanged = { newText ->
                            typing = newText
                        },
                        state = viewModel.state.collectAsState()
                    )
 */