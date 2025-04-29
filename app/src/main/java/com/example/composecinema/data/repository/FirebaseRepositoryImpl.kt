package com.example.composecinema.data.repository

import com.example.composecinema.core.FirebaseCallHelper
import com.example.composecinema.core.OperationStatus
import com.example.composecinema.domain.repository.FirebaseRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class FirebaseRepositoryImpl(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore,
) : FirebaseRepository {

    override suspend fun getUsername(): OperationStatus<String> {
        return FirebaseCallHelper.safeFirebaseCall {
            val userId = auth.currentUser?.uid
                ?: throw IllegalStateException("User not authenticated")

            val document = firestore.collection("users").document(userId).get().await()

            if (document.exists()) {
                document.getString("name") ?: throw IllegalStateException("Username not found")
            } else {
                throw IllegalStateException("User document not found")
            }
        }
    }

}
