package com.example.composecinema.presentation.navigation_graph

import kotlinx.serialization.Serializable

@Serializable
sealed interface NavDest {

    @Serializable
    data object Welcome : NavDest

    @Serializable
    data object Login : NavDest

    @Serializable
    data object SignUp : NavDest

    // Here should be bottom navigation destination
    @Serializable
    data object Home : NavDest

    @Serializable
    data object Search : NavDest

    @Serializable
    data object Favorite : NavDest

    @Serializable
    data object Profile : NavDest
}
