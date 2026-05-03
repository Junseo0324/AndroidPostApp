package com.devhjs.androidstudy.presentation.post

sealed interface PostAction {
    data class PostClick(val postId: Int) : PostAction
    data object BackClick : PostAction
}