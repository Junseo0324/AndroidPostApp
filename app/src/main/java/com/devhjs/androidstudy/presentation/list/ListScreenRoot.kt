package com.devhjs.androidstudy.presentation.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ListScreenRoot(
    viewModel: ListViewModel = hiltViewModel(),
    onNavigateToPost: (Int) -> Unit,
    onNavigateToAlbum: (Int) -> Unit
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                is ListEvent.OnNavigateToPost -> onNavigateToPost(event.userId)
                is ListEvent.OnNavigateToAlbum -> onNavigateToAlbum(event.userId)
            }
        }
    }
    ListScreen(
        state = state,
        onAction = viewModel::onAction
    )
}