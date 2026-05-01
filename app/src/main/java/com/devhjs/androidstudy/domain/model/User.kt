package com.devhjs.androidstudy.domain.model

data class User(
    val id: Int,
    val email: String,
    val name: String,
    val phone: String,
    val username: String,
    val website: String,
    val address: Address,
    val company: Company,
)
