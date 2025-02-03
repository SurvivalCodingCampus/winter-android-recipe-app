package com.surivalcoding.composerecipeapp.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.ui.component.BigButton
import com.surivalcoding.composerecipeapp.ui.component.CustomTabsExample
import com.surivalcoding.composerecipeapp.ui.component.InputFieldExample
import com.surivalcoding.composerecipeapp.ui.component.MediumButton
import com.surivalcoding.composerecipeapp.ui.component.SmallButton
import com.surivalcoding.composerecipeapp.ui.screen.SavedRecipeListScreen
import com.surivalcoding.composerecipeapp.ui.screen.SearchRecipesScreen
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme
import com.surivalcoding.composerecipeapp.ui.viewmodel.RecipeViewModel
import com.surivalcoding.composerecipeapp.ui.viewmodel.SearchRecipesViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    private val viewModel: SearchRecipesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        //WindowCompat.setDecorFitsSystemWindows(window, false)

        setContent {
            ComposeRecipeAppTheme {
//                SearchRecipesScreen()

                SearchRecipesScreen(viewModel = viewModel)
//                Column(
//                    verticalArrangement = Arrangement.spacedBy(16.dp)
//                ) {
//                    IngredientItemExample()
//                    RecipeCardExample()
//                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    ComposeRecipeAppTheme {
        Column(
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            BigButton(
                text = "컴포즈"
            )
            MediumButton(
                text = "컴포즈"
            )
            SmallButton(
                text = "컴포즈"
            )
            CustomTabsExample()
            InputFieldExample()
        }
    }
}