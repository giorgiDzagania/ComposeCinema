package com.example.composecinema.presentation.screens.core_screens.home_page

sealed class HomePageEvent {
    object OnSearchClick : HomePageEvent()
    object LoadUser : HomePageEvent()
    object ResetNavigation : HomePageEvent()
}
