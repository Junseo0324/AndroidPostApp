package com.devhjs.androidstudy.presentation.detail

sealed interface DetailEvent {
    data object onBackClick: DetailEvent
}