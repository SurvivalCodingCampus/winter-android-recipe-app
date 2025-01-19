package com.surivalcoding.composerecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.SavedRecipesScreen
import com.surivalcoding.composerecipeapp.presentation.saved_recipes.SavedRecipesViewModel
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val viewModel: SavedRecipesViewModel by viewModels { SavedRecipesViewModel.Factory }  // 이거 안 쓰면 화면 돌릴 때 날아간다
        enableEdgeToEdge()

        // Compose 화면 설정
        setContent {
            ComposeRecipeAppTheme {
                // ViewModel의 `savedRecipes` 상태를 수집 (Flow 기반 상태 관리)
                val recipes = viewModel.savedRecipes.collectAsState()
                // SavedRecipesScreen에 수집한 상태를 전달해 UI 렌더링
                SavedRecipesScreen(recipes = recipes.value)
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
        Greeting("Android")
    }
}