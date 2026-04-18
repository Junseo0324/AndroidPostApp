package com.devhjs.androidstudy.presentation.ui.list

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.devhjs.androidstudy.presentation.ui.component.PostItem

@Composable
fun ListScreen() {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        LazyColumn(
            modifier = Modifier.fillMaxSize()
        ) {
            PostItem()
        }
    }
}

@Preview
@Composable
private fun ListScreenPreview() {
    ListScreen()
}