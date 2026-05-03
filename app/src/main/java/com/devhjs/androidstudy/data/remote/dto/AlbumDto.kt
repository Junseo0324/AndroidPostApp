package com.devhjs.androidstudy.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class AlbumDto(
    val userId: Int? = null,
    val id: Int? = null,
    val title: String? = null
)
