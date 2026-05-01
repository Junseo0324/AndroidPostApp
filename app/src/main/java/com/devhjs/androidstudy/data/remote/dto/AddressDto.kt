package com.devhjs.androidstudy.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class AddressDto(
    val city: String? = null,
    val geo: GeoDto? = null,
    val street: String? = null,
    val suite: String? = null,
    val zipcode: String? = null,
)