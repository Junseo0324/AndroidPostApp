package com.devhjs.androidstudy.presentation.main

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@Composable
fun MainScreen(
    content: @Composable (Modifier) -> Unit
) {
    Scaffold(
        containerColor = Color.Black,
    ) { innerPadding ->
        content(Modifier.padding(innerPadding))
    }
}