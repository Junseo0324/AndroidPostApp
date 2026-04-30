package com.devhjs.androidstudy.core.routing

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.devhjs.androidstudy.presentation.detail.DetailScreenRoot
import com.devhjs.androidstudy.presentation.list.ListScreenRoot

@Composable
fun MainNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = MainRoute.Home,
        modifier = modifier
    ) {

        composable<MainRoute.Home> {
            ListScreenRoot()
        }

        composable<MainRoute.Detail> {
            DetailScreenRoot(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

    }

}