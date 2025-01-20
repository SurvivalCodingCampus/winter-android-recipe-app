import com.surivalcoding.composerecipeapp.data.recipe.ingrident.IngredientModel

interface IngredientDataSource {
    suspend fun getIngredients(): List<IngredientModel>
}
