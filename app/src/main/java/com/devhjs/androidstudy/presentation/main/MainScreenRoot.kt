package com.devhjs.androidstudy.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.devhjs.androidstudy.core.routing.MainNavGraph

@Composable
fun MainScreenRoot(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    MainScreen { padding ->
        MainNavGraph(
            navController = navController,
            modifier = padding
        )
    }


}