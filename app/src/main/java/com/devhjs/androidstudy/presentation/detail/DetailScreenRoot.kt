package com.devhjs.androidstudy.presentation.detail

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel

@Composable
fun DetailScreenRoot(
    modifier: Modifier = Modifier,
    postId: Int,
    viewModel: DetailViewModel = hiltViewModel()
) {
    DetailScreen()
}