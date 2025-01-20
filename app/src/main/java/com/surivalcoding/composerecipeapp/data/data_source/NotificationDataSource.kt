

interface IngredientDataSource {
    suspend fun getIngredients(): List<IngredientModel>
}