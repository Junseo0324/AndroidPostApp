package com.devhjs.androidstudy.presentation.album

import androidx.compose.runtime.Immutable
import com.devhjs.androidstudy.domain.model.Album

@Immutable
data class AlbumState(
    val isLoading: Boolean = false,
    val albums: List<Album> = emptyList(),
    val error: String = ""
)
