package com.devhjs.androidstudy.presentation.user

sealed interface UserEvent {
    data class NavigateToPost(val id: Int) : UserEvent
}