package com.surivalcoding.composerecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.example.Counter
import com.surivalcoding.composerecipeapp.presentation.component.BasicTab
import com.surivalcoding.composerecipeapp.presentation.component.IngredientItem
import com.surivalcoding.composerecipeapp.presentation.component.RecipeCard
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // enableEdgeToEdge()
        setContent {
           RecipeCard(
               imageUrl = "https://png.pngtree.com/thumb_back/fh260/background/20230907/pngtree-rice-and-meat-in-japanese-bowl-with-kimchi-image_13347644.jpg",
               recipeName = "Traditional spare ribs\nbaked",
               chefName = "By Chef John",
               cookingTime = 20,
               rate = 4.0
               )
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