package com.example.composecinema.presentation.screens.mainPage

sealed class MainPageEvent {
    object OnSearchClick : MainPageEvent()
    object LoadUser : MainPageEvent()
    object ResetNavigation : MainPageEvent()
}
