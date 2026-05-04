package com.devhjs.androidstudy.presentation.photo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun PhotoScreenRoot(
    viewModel: PhotoViewModel = hiltViewModel(),
    onBackClick: () -> Unit = {},
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    PhotoScreen(
        state = state,
        onAction = viewModel::onAction
    )
}