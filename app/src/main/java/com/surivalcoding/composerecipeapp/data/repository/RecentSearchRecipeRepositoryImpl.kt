package com.surivalcoding.composerecipeapp.data.repository

import com.surivalcoding.composerecipeapp.data.mock.fakeSearchRecipe
import com.surivalcoding.composerecipeapp.data.model.SearchRecipe
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class RecentSearchRecipeRepositoryImpl @Inject constructor() : RecentSearchRecipeRepository {
    override fun getRecentSearchRecipe(): Flow<List<SearchRecipe>> =
        flowOf(fakeSearchRecipe)
}