package com.devhjs.androidstudy.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class Geo(
    val lat: String,
    val lng: String
)