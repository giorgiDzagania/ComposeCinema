package com.example.composecinema.di

import com.example.composecinema.data.repository.AuthRepositoryImpl
import com.example.composecinema.data.repository.FirebaseRepositoryImpl
import com.example.composecinema.domain.repository.AuthRepository
import com.example.composecinema.domain.repository.FirebaseRepository
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module

val repositoryModule = module {
    singleOf(::AuthRepositoryImpl) bind AuthRepository::class
    singleOf(::FirebaseRepositoryImpl) bind FirebaseRepository::class
}