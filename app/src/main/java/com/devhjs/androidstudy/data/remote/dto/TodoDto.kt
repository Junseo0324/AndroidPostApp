package com.devhjs.androidstudy.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class TodoDto(
    val userId: Int? = null,
    val id: Int? = null,
    val title: String? = null,
    val completed: Boolean? = null,
)
