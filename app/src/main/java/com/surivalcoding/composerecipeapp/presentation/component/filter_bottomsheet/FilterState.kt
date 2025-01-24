package com.surivalcoding.composerecipeapp.presentation.component.filter_bottomsheet

import com.surivalcoding.composerecipeapp.domain.model.enums.TimeFilter

data class FilterState(
    val timeFilter: TimeFilter? = null,
    val rateFilter: Int? = null,
    val categoryFilter: String? = null
)