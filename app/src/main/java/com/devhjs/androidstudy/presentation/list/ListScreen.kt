package com.devhjs.androidstudy.presentation.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.devhjs.androidstudy.presentation.component.PostItem

@Composable
fun ListScreen(
    state: ListState,
    onAction: (ListAction) -> Unit = {},
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            items(state.posts) { post ->
                PostItem(
                    post = post,
                    onAction = onAction
                )
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
private fun ListScreenPreview() {
    ListScreen(
        state = ListState()
    )
}