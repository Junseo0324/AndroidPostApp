package com.devhjs.androidstudy.presentation.photo

import androidx.compose.runtime.Immutable
import com.devhjs.androidstudy.domain.model.Photo

@Immutable
data class PhotoState(
    val isLoading: Boolean = false,
    val photos: List<Photo> = emptyList(),
    val error: String = ""
)
