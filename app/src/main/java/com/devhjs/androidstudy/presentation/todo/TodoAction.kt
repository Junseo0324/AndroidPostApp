package com.devhjs.androidstudy.presentation.todo

sealed interface TodoAction {
    data object OnBackClick : TodoAction
}