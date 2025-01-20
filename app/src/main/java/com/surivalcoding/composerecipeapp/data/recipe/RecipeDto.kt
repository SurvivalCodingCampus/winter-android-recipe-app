
//data class RecipeDto_(
//    val id: String = "",
//    val title: String = "",
//    val procedure: List<String> = emptyList(),
//    val ingredients: List<IngredientDto> = emptyList(),
//    val category: String = "",
//    val cookingDuration: Int = 0,
//    val serving: Int = 0,
//    val thumbnailUrl: String? = null,
//    val videoUrl: String? = null,
//    val shareUrl: String? = null,
//    val starRate: Float = 0f,
//    val savedCount: Int = 0,
//    val createdBy: String = "",
//    val createdAt: Long = 0,
//    val editedAt: Long? = null
//) {
//    fun toModel() = com.surivalcoding.composerecipeapp.data.recipe.RecipeModel(
//        id = id,
//        title = title,
//        procedure = procedure,
//        ingredients = ingredients.map { it.toModel() },
//        category = category,
//        cookingDuration = cookingDuration,
//        serving = serving,
//        thumbnailUrl = thumbnailUrl,
//        videoUrl = videoUrl,
//        shareUrl = shareUrl,
//        starRate = starRate,
//        savedCount = savedCount,
//        createdBy = createdBy,
//        createdAt = createdAt,
//        editedAt = editedAt
//    )
//}