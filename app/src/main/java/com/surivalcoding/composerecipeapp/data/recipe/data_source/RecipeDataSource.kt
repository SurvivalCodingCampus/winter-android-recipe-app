
interface RecipeDataSource {
    suspend fun getSearchRecipes(keyword: String): List<Recipe>
    suspend fun createRecipe(recipe: Recipe)
}