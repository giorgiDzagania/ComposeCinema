package com.example.composecinema.di

import com.example.composecinema.presentation.screens.logInScreen.LogInViewModel
import com.example.composecinema.presentation.screens.mainPage.MainPageViewModel
import com.example.composecinema.presentation.screens.signScreen.SignUpViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::SignUpViewModel)
    viewModelOf(::LogInViewModel)
    viewModelOf(::MainPageViewModel)
}
