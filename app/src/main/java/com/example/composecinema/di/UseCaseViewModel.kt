package com.example.composecinema.di

import com.example.composecinema.domain.useCases.AuthUseCase
import org.koin.dsl.module

val useCaseViewModel = module {
    factory { AuthUseCase(get()) }
}