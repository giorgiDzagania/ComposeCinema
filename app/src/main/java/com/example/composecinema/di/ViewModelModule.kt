package com.example.composecinema.di

import com.example.composecinema.presentation.screens.auth_screens.log_In_screen.LogInViewModel
import com.example.composecinema.presentation.screens.core_screens.home_page.HomePageViewModel
import com.example.composecinema.presentation.screens.auth_screens.sign_up_screen.SignUpViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::SignUpViewModel)
    viewModelOf(::LogInViewModel)
    viewModelOf(::HomePageViewModel)
}
