package com.devhjs.androidstudy.data.mapper

import com.devhjs.androidstudy.data.remote.dto.CompanyDto
import com.devhjs.androidstudy.domain.model.Company

fun Company.toDto(): CompanyDto {
    return CompanyDto(
        bs = bs,
        catchPhrase = catchPhrase,
        name = name,
    )
}

fun CompanyDto.toModel(): Company {
    return Company(
        bs = bs ?: "",
        catchPhrase = catchPhrase ?: "",
        name = name ?: "",
    )
}