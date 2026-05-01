package com.devhjs.androidstudy.presentation.user

import com.devhjs.androidstudy.domain.model.User

data class UserState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String = ""
)
