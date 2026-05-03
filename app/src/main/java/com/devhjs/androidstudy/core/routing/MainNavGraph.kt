package com.devhjs.androidstudy.core.routing

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.devhjs.androidstudy.presentation.list.ListScreenRoot
import com.devhjs.androidstudy.presentation.post.PostScreenRoot
import com.devhjs.androidstudy.presentation.postdetail.PostDetailScreenRoot
import com.devhjs.androidstudy.presentation.user.UserScreenRoot

@Composable
fun MainNavGraph(
    navController: NavHostController,
    modifier: Modifier = Modifier
) {
    NavHost(
        navController = navController,
        startDestination = MainRoute.User,
        modifier = modifier
    ) {

        composable<MainRoute.Post> {
            PostScreenRoot(
                navigateToDetail = { postId ->
                    navController.navigate(MainRoute.PostDetail(postId))
                },
                navigateToBack = {
                    navController.popBackStack()
                }
            )
        }

        composable<MainRoute.List> {
            ListScreenRoot(
                onNavigateToPost = { userId ->
                    navController.navigate(MainRoute.Post(userId))
                },
                onNavigateToAlbum = { userId ->
                    navController.navigate(MainRoute.Album(userId))
                }
            )
        }


        composable<MainRoute.PostDetail> {
            PostDetailScreenRoot(
                onBackClick = {
                    navController.popBackStack()
                }
            )
        }

        composable<MainRoute.User> {
            UserScreenRoot(
                onNavigateToList = { userId ->
                    navController.navigate(MainRoute.List(userId))
                }
            )
        }

    }

}