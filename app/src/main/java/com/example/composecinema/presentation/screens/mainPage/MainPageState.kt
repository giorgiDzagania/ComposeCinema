package com.example.composecinema.presentation.screens.mainPage

data class MainPageState(
    val userName: String? = null,
    val loading: Boolean = false,
    val errorMessage: String = "",
    val navigateToSearchScreen: Boolean = false
)
