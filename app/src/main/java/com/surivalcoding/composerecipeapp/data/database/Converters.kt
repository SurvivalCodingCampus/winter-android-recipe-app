package com.surivalcoding.composerecipeapp.data.database

import androidx.room.TypeConverter
import com.surivalcoding.composerecipeapp.domain.model.Ingredient
import kotlinx.serialization.encodeToString
import kotlinx.serialization.json.Json
import kotlinx.serialization.json.Json.Default.decodeFromString

class Converters {
    // json 문자열로 변환
    @TypeConverter
    fun fromIngredientList(value: List<Ingredient>): String {
        return Json.encodeToString(value)
    }

    // List<Ingredient>로 변환
    @TypeConverter
    fun toIngredientList(value: String): List<Ingredient> {
        return decodeFromString(value)
    }

    // json 문자열로 변환
    @TypeConverter
    fun fromProcedureList(value: List<String>): String {
        return Json.encodeToString(value)
    }

    // List<String>으로 변환
    @TypeConverter
    fun toProcedureList(value: String): List<String> {
        return decodeFromString(value)
    }
}