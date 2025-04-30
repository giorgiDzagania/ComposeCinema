package com.example.composecinema.presentation.screens.core_screens.home_page

data class HomePageState(
    val userName: String? = null,
    val loading: Boolean = false,
    val errorMessage: String = "",
    val navigateToSearchScreen: Boolean = false
)
