package com.devhjs.androidstudy.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class UserDto(
    val id: Int? = null,
    val email: String? = null,
    val name: String? = null,
    val phone: String? = null,
    val username: String? = null,
    val website: String? = null,
    val addressDto: AddressDto? = null,
    val company: CompanyDto? = null,
)