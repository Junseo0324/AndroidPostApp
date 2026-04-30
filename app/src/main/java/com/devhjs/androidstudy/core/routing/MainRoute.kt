package com.devhjs.androidstudy.core.routing

import kotlinx.serialization.Serializable

sealed interface MainRoute {

    @Serializable
    data object Home : MainRoute

    @Serializable
    data class Detail(val id: Int) : MainRoute
}