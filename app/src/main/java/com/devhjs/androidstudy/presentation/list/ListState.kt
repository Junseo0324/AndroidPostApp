package com.devhjs.androidstudy.presentation.list

import androidx.compose.runtime.Immutable
import com.devhjs.androidstudy.domain.model.Post

@Immutable
data class ListState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
)
