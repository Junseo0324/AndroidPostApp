package com.devhjs.androidstudy.presentation.user

sealed interface UserAction {
    data class UserClick(val id: Int) : UserAction
}