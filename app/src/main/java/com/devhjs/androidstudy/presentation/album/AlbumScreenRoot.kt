package com.devhjs.androidstudy.presentation.album

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun AlbumScreenRoot(
    viewModel: AlbumViewModel = hiltViewModel(),
    onNavigateToPhoto: (Int) -> Unit = {},
    onBackClick: () -> Unit = {},
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                is AlbumEvent.OnNavigateToPhoto -> {
                    onNavigateToPhoto(event.photoId)
                }

                is AlbumEvent.OnBackClick -> {
                    onBackClick()
                }
            }
        }
    }

    AlbumScreen(
        state = state,
        onAction = viewModel::onAction
    )
}