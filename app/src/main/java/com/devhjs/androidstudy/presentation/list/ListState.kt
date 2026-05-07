package com.devhjs.androidstudy.presentation.list

data class ListState(
    val isLoading: Boolean = false,
    val postSize: Int = 0,
    val albumSize: Int = 0,
    val todoSize: Int = 0,
    val error: String = ""
)
