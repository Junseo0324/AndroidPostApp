package com.devhjs.androidstudy.data.mapper

import com.devhjs.androidstudy.data.remote.dto.UserDto
import com.devhjs.androidstudy.domain.model.Address
import com.devhjs.androidstudy.domain.model.Company
import com.devhjs.androidstudy.domain.model.Geo
import com.devhjs.androidstudy.domain.model.User


fun User.toDto(): UserDto {
    return UserDto(
        id = id,
        email = email,
        name = name,
        phone = phone,
        username = username,
        website = website,
        addressDto = address.toDto(),
        company = company.toDto(),
    )
}

fun UserDto.toModel(): User {
    return User(
        id = id ?: 0,
        email = email ?: "",
        name = name ?: "",
        phone = phone ?: "",
        username = username ?: "",
        website = website ?: "",
        address = addressDto?.toModel() ?: Address(
            city = "",
            geo = Geo("", ""),
            street = "",
            suite = "",
            zipcode = "",
        ),
        company = company?.toModel() ?: Company(
            bs = "",
            catchPhrase = "",
            name = "",
        ),
    )
}