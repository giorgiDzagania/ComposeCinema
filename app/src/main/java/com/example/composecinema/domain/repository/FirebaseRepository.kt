package com.example.composecinema.domain.repository

import com.example.composecinema.core.OperationStatus

interface FirebaseRepository {
    suspend fun getUsername(): OperationStatus<String>
}