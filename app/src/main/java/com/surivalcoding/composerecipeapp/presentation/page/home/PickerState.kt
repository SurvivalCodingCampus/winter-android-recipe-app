package com.surivalcoding.composerecipeapp.presentation.page.home

import com.surivalcoding.composerecipeapp.presentation.page.searchrecipe.Category

data class PickerState(
    val buttonState: Category = Category.All
)
