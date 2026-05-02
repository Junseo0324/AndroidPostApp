package com.devhjs.androidstudy.presentation.post

sealed interface PostEvent {
    data class onPostClick(val postId: Int) : PostEvent
}