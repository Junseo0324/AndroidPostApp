package com.devhjs.androidstudy.presentation.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ListScreenRoot(
    viewModel: ListScreenViewModel= hiltViewModel(),
    navigateToDetail: (Int) -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                is ListEvent.onPostClick -> {
                    navigateToDetail(event.postId)
                }
            }
        }
    }

    ListScreen(
        state = state,
        onAction = viewModel::onAction
    )
}