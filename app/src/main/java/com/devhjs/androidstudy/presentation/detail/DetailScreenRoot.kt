package com.devhjs.androidstudy.presentation.detail

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun DetailScreenRoot(
    modifier: Modifier = Modifier,
    onBackClick: () -> Unit = {},
    viewModel: DetailViewModel = hiltViewModel(),
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                DetailEvent.onBackClick -> {
                    onBackClick()
                }
            }
        }
    }
    DetailScreen(
        state = state,
        onAction = viewModel::onAction,
    )
}