package com.example.composecinema.data.repository

import com.example.composecinema.core.FirebaseCallHelper
import com.example.composecinema.core.OperationStatus
import com.example.composecinema.domain.repository.AuthRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await

class AuthRepositoryImpl(
    private val auth: FirebaseAuth,
    private val firestore: FirebaseFirestore
) : AuthRepository {

    override suspend fun signUp(
        name: String,
        email: String,
        password: String
    ): OperationStatus<FirebaseUser> {
        return FirebaseCallHelper.safeFirebaseCall {
            val authResult = auth.createUserWithEmailAndPassword(email, password).await()
            val user = authResult.user ?: throw Exception("User registration failed")

            val userMap = mapOf(
                "uid" to user.uid,
                "name" to name,
                "email" to email,
                "password" to password
            )

            firestore.collection("users")
                .document(user.uid)
                .set(userMap)
                .await()

            user
        }
    }

    override suspend fun loginIn(email: String, password: String): OperationStatus<FirebaseUser> {
        return FirebaseCallHelper.safeFirebaseCall {
            val resultUser = auth.signInWithEmailAndPassword(email, password).await()
            resultUser.user!!
        }
    }
}
