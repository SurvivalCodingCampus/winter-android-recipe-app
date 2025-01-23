package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.model.SearchRecipe
import kotlinx.coroutines.flow.Flow

interface RecentSearchRecipeRepository {
    fun getRecentSearchRecipe(): Flow<List<SearchRecipe>>
}