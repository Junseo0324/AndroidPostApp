package com.devhjs.androidstudy.presentation.user

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun UserScreenRoot(
    viewModel: UserViewModel = hiltViewModel()
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    UserScreen(state = state)
}