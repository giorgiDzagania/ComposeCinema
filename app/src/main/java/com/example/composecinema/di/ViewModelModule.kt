package com.example.composecinema.di

import com.example.composecinema.presentation.screens.signUpScreen.SignUpViewModel
import org.koin.core.module.dsl.viewModelOf
import org.koin.dsl.module

val viewModelModule = module {
    viewModelOf(::SignUpViewModel)
}