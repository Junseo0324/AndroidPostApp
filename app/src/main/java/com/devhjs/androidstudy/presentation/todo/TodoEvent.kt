package com.devhjs.androidstudy.presentation.todo

sealed interface TodoEvent {
    data object OnBackClick : TodoEvent
}