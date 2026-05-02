package com.devhjs.androidstudy.presentation.post

import androidx.compose.runtime.Immutable
import com.devhjs.androidstudy.domain.model.Post

@Immutable
data class PostState(
    val isLoading: Boolean = false,
    val posts: List<Post> = emptyList(),
)
