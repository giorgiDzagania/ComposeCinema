package com.example.composecinema.di

import com.example.composecinema.domain.useCases.authenticationUseCases.AuthUseCase
import com.example.composecinema.domain.useCases.authenticationUseCases.LogInUseCase
import com.example.composecinema.domain.useCases.userDetailsUseCases.GetUserNameUseCase
import org.koin.dsl.module

val useCaseViewModel = module {
    factory { AuthUseCase(get()) }
    factory { LogInUseCase(get()) }
    factory { GetUserNameUseCase(get()) }
}