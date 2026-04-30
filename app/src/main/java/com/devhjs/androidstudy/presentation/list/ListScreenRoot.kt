package com.devhjs.androidstudy.presentation.list

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.compose.collectAsStateWithLifecycle

@Composable
fun ListScreenRoot(
    modifier: Modifier = Modifier,
    viewModel: ListScreenViewModel,
) {
    val state by viewModel.state.collectAsStateWithLifecycle()

    ListScreen(state = state)
}