package com.devhjs.androidstudy.data.mapper

import com.devhjs.androidstudy.data.remote.dto.AddressDto
import com.devhjs.androidstudy.domain.model.Address
import com.devhjs.androidstudy.domain.model.Geo


fun Address.toDto(): AddressDto {
    return AddressDto(
        city = city,
        geo = geo.toDto(),
        street = street,
        suite = suite,
        zipcode = zipcode,
    )
}

fun AddressDto.toModel(): Address {
    return Address(
        city = city ?: "",
        geo = geo?.toModel() ?: Geo("", ""),
        street = street ?: "",
        suite = suite ?: "",
        zipcode = zipcode ?: "",
    )
}