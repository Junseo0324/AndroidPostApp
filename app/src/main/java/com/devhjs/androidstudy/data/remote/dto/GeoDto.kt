package com.devhjs.androidstudy.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class GeoDto(
    val lat: String? = null,
    val lng: String? = null,
)