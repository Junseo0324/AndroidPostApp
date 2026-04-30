package com.devhjs.androidstudy.presentation.main

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.devhjs.androidstudy.core.routing.MainNavGraph

@Composable
fun MainScreenRoot(modifier: Modifier = Modifier) {
    val navController = rememberNavController()

    val currentBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = currentBackStackEntry?.destination?.route

    MainScreen {
        MainNavGraph(
            navController = navController,
            modifier = modifier
        )
    }


}