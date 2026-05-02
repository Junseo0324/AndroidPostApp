package com.devhjs.androidstudy.presentation.post

sealed interface PostAction {
    data class onPostClick(val postId: Int) : PostAction
}