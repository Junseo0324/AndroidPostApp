package com.devhjs.androidstudy.presentation.todo

import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview

@Composable
fun TodoScreen(
    state: TodoState = TodoState(),
    onBackClick: () -> Unit = {},
) {

}

@Preview
@Composable
private fun TodoScreenPreview() {
    TodoScreen()
}