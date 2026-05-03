package com.devhjs.androidstudy.presentation.user

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun UserScreenRoot(
    viewModel: UserViewModel = hiltViewModel(),
    onNavigateToPost: (Int) -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                is UserEvent.NavigateToPost -> {
                    onNavigateToPost(event.id)
                }
            }
        }
    }

    UserScreen(
        state = state,
        onAction = viewModel::onAction
    )
}