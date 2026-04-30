package com.devhjs.androidstudy.presentation.list

sealed interface ListAction {
    data class onPostClick(val postId: Int) : ListAction
}