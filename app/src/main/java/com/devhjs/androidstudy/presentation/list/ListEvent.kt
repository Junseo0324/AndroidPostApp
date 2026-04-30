package com.devhjs.androidstudy.presentation.list

sealed interface ListEvent {
    data class onPostClick(val postId: Int) : ListEvent
}