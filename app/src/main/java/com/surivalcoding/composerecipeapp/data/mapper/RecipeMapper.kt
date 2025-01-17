import kotlinx.serialization.Serializable


// Domain Models
data class Recipe(
    val id: Int,
    val category: String,
    val name: String,
    val image: String,
    val chef: String,
    val time: String,
    val rating: Double,
    val ingredients: List<RecipeIngredient>
)

data class RecipeIngredient(
    val ingredient: Ingredient,
    val amount: Int
)

data class Ingredient(
    val id: Int,
    val name: String,
    val image: String
)

// DTOs
@Serializable
data class RecipeDto(
    val id: Int = 0,
    val category: String = "",
    val name: String = "",
    val image: String = "",
    val chef: String = "",
    val time: String = "",
    val rating: Double = 0.0,
    val ingredients: List<RecipeIngredientDto> = emptyList()
)

@Serializable
data class RecipeIngredientDto(
    val ingredient: IngredientDto = IngredientDto(),
    val amount: Int = 0
)

@Serializable
data class IngredientDto(
    val id: Int = 0,
    val name: String = "",
    val image: String = ""
)

// Response DTO
@Serializable
data class RecipeResponseDto(
    val recipes: List<RecipeDto> = emptyList()
)

// Mappers
fun RecipeDto.toModel() = Recipe(
    id = id,
    category = category,
    name = name,
    image = image,
    chef = chef,
    time = time,
    rating = rating,
    ingredients = ingredients.map { it.toModel() }
)

fun RecipeIngredientDto.toModel() = RecipeIngredient(
    ingredient = ingredient.toModel(),
    amount = amount
)

fun IngredientDto.toModel() = Ingredient(
    id = id,
    name = name,
    image = image
)

fun Recipe.toDto() = RecipeDto(
    id = id,
    category = category,
    name = name,
    image = image,
    chef = chef,
    time = time,
    rating = rating,
    ingredients = ingredients.map { it.toDto() }
)

fun RecipeIngredient.toDto() = RecipeIngredientDto(
    ingredient = ingredient.toDto(),
    amount = amount
)

fun Ingredient.toDto() = IngredientDto(
    id = id,
    name = name,
    image = image
)

// List Extensions
fun List<RecipeDto>.toModels() = map { it.toModel() }
fun List<Recipe>.toDtos() = map { it.toDto() }