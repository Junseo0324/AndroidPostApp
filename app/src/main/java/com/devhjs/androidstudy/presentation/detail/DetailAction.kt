package com.devhjs.androidstudy.presentation.detail

sealed interface DetailAction {
    data object onBackClick: DetailAction
}