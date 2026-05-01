package com.devhjs.androidstudy.data.remote.dto

import kotlinx.serialization.Serializable

@Serializable
data class CompanyDto(
    val bs: String? = null,
    val catchPhrase: String? = null,
    val name: String? = null,
)