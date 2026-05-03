package com.devhjs.androidstudy.presentation.post

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun PostScreenRoot(
    viewModel: PostScreenViewModel= hiltViewModel(),
    navigateToDetail: (Int) -> Unit = {},
    navigateToBack: () -> Unit = {}
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                is PostEvent.OnPostClick -> {
                    navigateToDetail(event.postId)
                }
                is PostEvent.OnBackClick -> {
                    navigateToBack()
                }
            }
        }
    }

    PostScreen(
        state = state,
        onAction = viewModel::onAction
    )
}