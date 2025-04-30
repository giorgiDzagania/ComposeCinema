package com.example.composecinema.di

import com.example.composecinema.domain.use_cases.auth_use_case.SignUpUseCase
import com.example.composecinema.domain.use_cases.auth_use_case.LogInUseCase
import com.example.composecinema.domain.use_cases.auth_use_case.GetUserNameUseCase
import org.koin.dsl.module

val useCaseViewModel = module {
    factory { SignUpUseCase(get()) }
    factory { LogInUseCase(get()) }
    factory { GetUserNameUseCase(get()) }
}