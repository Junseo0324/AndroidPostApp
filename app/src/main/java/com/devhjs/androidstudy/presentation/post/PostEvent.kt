package com.devhjs.androidstudy.presentation.post

sealed interface PostEvent {
    data class OnPostClick(val postId: Int) : PostEvent
    data object OnBackClick : PostEvent
}