package com.example.composecinema.di

import com.example.composecinema.domain.useCases.auth_usecase.SignInUseCase
import com.example.composecinema.domain.useCases.auth_usecase.SignUseCase
import org.koin.dsl.module

val useCaseViewModel = module {
    factory { SignUseCase(get()) }
    factory { SignInUseCase(get()) }
}