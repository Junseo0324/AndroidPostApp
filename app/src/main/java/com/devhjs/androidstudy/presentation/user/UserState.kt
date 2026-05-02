package com.devhjs.androidstudy.presentation.user

import androidx.compose.runtime.Immutable
import com.devhjs.androidstudy.domain.model.User

@Immutable
data class UserState(
    val isLoading: Boolean = false,
    val users: List<User> = emptyList(),
    val error: String = ""
)
