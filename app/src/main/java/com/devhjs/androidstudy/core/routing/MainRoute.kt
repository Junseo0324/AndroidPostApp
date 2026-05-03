package com.devhjs.androidstudy.core.routing

import kotlinx.serialization.Serializable

sealed interface MainRoute {

    @Serializable
    data object User : MainRoute

    @Serializable
    data class Post(val userId: Int) : MainRoute

    @Serializable
    data class PostDetail(val id: Int) : MainRoute

    @Serializable
    data class Comment(val postId: Int) : MainRoute

    @Serializable
    data class Album(val userId: Int) : MainRoute

    @Serializable
    data class Photo(val albumId: Int) : MainRoute

    @Serializable
    data class Todo(val userId: Int) : MainRoute
}