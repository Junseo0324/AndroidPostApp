package com.devhjs.androidstudy.presentation.todo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun TodoScreenRoot(
    viewModel: TodoViewModel = hiltViewModel(),
    onBackClick: () -> Unit,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                TodoEvent.OnBackClick -> onBackClick()
            }
        }
    }
    TodoScreen(
        state = state,
        onAction = viewModel::onAction,
    )

}