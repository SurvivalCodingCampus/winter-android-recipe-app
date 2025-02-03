package com.surivalcoding.composerecipeapp.presentation.page.profile

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.surivalcoding.composerecipeapp.presentation.page.main.ProfileScreen

@Composable
fun ProfileScreenRoot(
    viewModel: ProfileViewModel = hiltViewModel()
) {
    ProfileScreen(
        state = viewModel.profileState.collectAsStateWithLifecycle().value,
        onAction = viewModel::onAction
    )
}