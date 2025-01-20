package  com.surivalcoding.composerecipeapp.data.recipe.ingrident

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

// Domain Model
data class IngredientModel(
    val id: Int,
    val name: String,
    val image: String
)

// DTO
@Serializable
data class IngredientDto(
    @SerialName("id")
    val id: Int = 0,

    @SerialName("name")
    val name: String = "",

    @SerialName("image")
    val image: String = ""
)

// Response DTO for ingredients list
@Serializable
data class IngredientResponseDto(
    @SerialName("ingredients")
    val ingredients: List<IngredientDto> = emptyList()
)

// Mapper Extensions
fun IngredientDto.toModel() = IngredientModel(
    id = id,
    name = name,
    image = image
)

fun IngredientModel.toDto() = IngredientDto(
    id = id,
    name = name,
    image = image
)

// List Extensions
fun List<IngredientDto>.toModels() = map { it.toModel() }
fun List<IngredientModel>.toDtos() = map { it.toDto() }