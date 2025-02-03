package com.surivalcoding.composerecipeapp.presentation.page.profile

import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.ProfileCategory

data class FilterButtonState(
    val buttonState: ProfileCategory = ProfileCategory.RECIPE
)
