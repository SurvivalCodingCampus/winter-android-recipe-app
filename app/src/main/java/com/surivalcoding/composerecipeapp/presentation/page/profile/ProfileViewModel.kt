package com.surivalcoding.composerecipeapp.presentation.page.profile

import androidx.lifecycle.ViewModel
import com.orhanobut.logger.Logger
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

@HiltViewModel
class ProfileViewModel @Inject constructor() : ViewModel() {

    private val _profileState = MutableStateFlow(ProfileState())
    val profileState = _profileState.asStateFlow()

    fun onAction(action: ProfileAction) {
        when (action) {
            is ProfileAction.FilterCategory -> {
                _profileState.value = _profileState.value.copy(
                    filterButtonState = action.filterButtonState
                )
            }

            ProfileAction.MoreButton -> Logger.e("더보기 버튼 클릭!!")
        }
    }
}