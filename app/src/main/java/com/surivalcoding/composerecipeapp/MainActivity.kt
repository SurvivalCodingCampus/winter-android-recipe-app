package com.surivalcoding.composerecipeapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.surivalcoding.composerecipeapp.presentation.component.BigButton
import com.surivalcoding.composerecipeapp.presentation.component.FilterChip
import com.surivalcoding.composerecipeapp.presentation.component.Ingredient
import com.surivalcoding.composerecipeapp.presentation.component.IngredientItem
import com.surivalcoding.composerecipeapp.presentation.component.MediumButton
import com.surivalcoding.composerecipeapp.presentation.component.RatingDialog
import com.surivalcoding.composerecipeapp.presentation.component.Recipe
import com.surivalcoding.composerecipeapp.presentation.component.RecipeCard
import com.surivalcoding.composerecipeapp.presentation.component.SmallButton
import com.surivalcoding.composerecipeapp.ui.theme.ComposeRecipeAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ComposeRecipeAppTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    var chipSelected1 by rememberSaveable { mutableStateOf(false) }
                    var chipSelected2 by rememberSaveable { mutableStateOf(false) }
                    var chipSelected3 by rememberSaveable { mutableStateOf(false) }
                    Column(modifier = Modifier.padding(innerPadding)) {
                        BigButton(
                            modifier = Modifier,
                            buttonText = "버튼"
                        )
                        Spacer(Modifier.padding(vertical = 10.dp))
                        MediumButton(
                            modifier = Modifier,
                            buttonText = "버튼"
                        )
                        Spacer(Modifier.padding(vertical = 10.dp))
                        SmallButton(
                            modifier = Modifier,
                            buttonText = "버튼"
                        )
                        Spacer(Modifier.padding(vertical = 10.dp))
                        IngredientItem(
                            ingredient = Ingredient(
                                name = "Tomatos",
                                amount = 500,
                                imageUrl = "https://s3-alpha-sig.figma.com/img/3c30/4e61/3dd3e1dd1f7360a6ef1c04399b0609ab?Expires=1737936000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=YiqyiHT-Zf75PgFIhZQxqfcESF8MKWPUTlonvU3jheAOVv1huhxp7SglpH7uoZSIVWGlyY~u1IteavPE54fgxHO8G1XfSznhjP3U1uT5kX9gQVO7BAyrhf25xjiugekaJnOFlKBlgOAorCpNeCMxmvknb9UB6nqpASrBrkg0GAxt0ENYDZawsQ3rArK5ix7Xk0djrw33wYMpggc~4AvJ1QOJdlWag0Y2A9YrXPjf1rutmfTJ3d3GWYbrR1nPmAzAcTFbUGz40NJjEBQRJqgYlkNxb33zpUh6NzDrzZp-RGURdUYHrK-8JwhKUmjgjfWqR9fP-j5PUhHkn7MRdGVe3w__"
                            )
                        )
                        Spacer(Modifier.padding(vertical = 10.dp))
                        Row() {
                            FilterChip(
                                text = "Newest",
                                isSelected = chipSelected1,
                                onSelectionChange = { newState ->
                                    chipSelected1 = newState
                                }
                            )
                            Spacer(Modifier.padding(horizontal = 10.dp))
                            FilterChip(
                                text = "4",
                                showStar = true,
                                isSelected = chipSelected2,
                                onSelectionChange = { newState ->
                                    chipSelected2 = newState
                                }
                            )
                            Spacer(Modifier.padding(horizontal = 10.dp))
                            FilterChip(
                                text = "Dinner",
                                showStar = true,
                                isSelected = chipSelected3,
                                onSelectionChange = { newState ->
                                    chipSelected3 = newState
                                }
                            )
                        }
                        Spacer(Modifier.padding(vertical = 10.dp))
                        RatingDialog(
                            onRatingChange = {},
                            onDismiss = {}
                        )
                        RecipeCard(
                            recipe = Recipe(
                                title = "Spicy fried rice mix chicken bali",
                                creator = "Spicy Nelly",
                                imageUrl = "https://s3-alpha-sig.figma.com/img/2234/134e/6e53ef9148ab9085bbd1369e270f0bba?Expires=1737936000&Key-Pair-Id=APKAQ4GOSFWCVNEHN3O4&Signature=EqiXQQNVRFWuqESZom-1RtDiC9xnbTUwd86cR8JgxmbZsq-Jt-7BUsHJqphUR76SIa1H94xf3gs7-6Ox--ScLe82XIXZGRpAv~s8ovK0RjoEDU8lIIj6H6lPXgKGXFIwFQb3oO6d5SD4~61Vw0F-fX-RJ5Q-Gp86CzooV62~PykTQuptWK~zcSWnzIcus7zB4qLWW7Kqn0Ipb2zMeNjqj2U5Dm69ouwW~mz4Aw22hJQgkw4fzVDzoPIBEWcouxuRgrL4UY8Zb020hZ8yC7AipzhgR4h6fl5zia1qRSZBgHJ~suoyk571P0HZmX0s6tfInaIOnJmPdvGa0kDp3r~qqw__",
                                rating = 4.0f,
                                cookingTime = 20
                            )
                        )
                    }
                }
            }
        }
    }
}

/*
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
}*/
