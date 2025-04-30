package com.example.composecinema.presentation.screens.core_screens.home_screen

data class HomeState(
    val userName: String? = null,
    val loading: Boolean = false,
    val errorMessage: String = "",
    val navigateToSearchScreen: Boolean = false
)
