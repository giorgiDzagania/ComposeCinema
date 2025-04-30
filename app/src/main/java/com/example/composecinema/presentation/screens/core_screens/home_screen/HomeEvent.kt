package com.example.composecinema.presentation.screens.core_screens.home_screen

sealed class HomeEvent {
    object OnSearchClick : HomeEvent()
    object LoadUser : HomeEvent()
    object ResetNavigation : HomeEvent()
}
