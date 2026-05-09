package com.devhjs.androidstudy.presentation.photo

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.paging.compose.collectAsLazyPagingItems

@Composable
fun PhotoScreenRoot(
    viewModel: PhotoViewModel = hiltViewModel(),
    onBackClick: () -> Unit = {},
) {
//    val state by viewModel.state.collectAsStateWithLifecycle()
    val lazyPagingItems = viewModel.photoPagingData.collectAsLazyPagingItems()

    LaunchedEffect(Unit) {
        viewModel.event.collect { event ->
            when (event) {
                is PhotoEvent.OnPhotoClick -> {

                }

                is PhotoEvent.OnBackClick -> {
                    onBackClick()
                }
            }
        }
    }
    PhotoScreen(
        lazyPagingItems = lazyPagingItems,
        onAction = viewModel::onAction
    )
}