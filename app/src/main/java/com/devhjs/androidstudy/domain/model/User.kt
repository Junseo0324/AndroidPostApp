package com.devhjs.androidstudy.domain.model

import com.devhjs.androidstudy.data.remote.dto.AddressDto

data class User(
    val id: Int,
    val email: String,
    val name: String,
    val phone: String,
    val username: String,
    val website: String,
    val address: AddressDto
)
