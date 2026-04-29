package com.plum.salesacademy.data.remote

import com.plum.salesacademy.data.model.*
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("loginUser") suspend fun loginUser(@Body body: Map<String, String>): ApiResponse<User>
    @POST("verifyOtp") suspend fun verifyOtp(@Body body: Map<String, String>): ApiResponse<User>
    @POST("saveUserProfile") suspend fun saveUserProfile(@Body body: Map<String, String>): ApiResponse<Map<String, String>>
    @POST("getTrainingModules") suspend fun getTrainingModules(@Body body: Map<String, String>): ApiResponse<List<TrainingModule>>
    @POST("getQuizQuestions") suspend fun getQuizQuestions(@Body body: Map<String, String>): ApiResponse<List<Map<String, String>>>
    @POST("submitQuizAttempt") suspend fun submitQuizAttempt(@Body body: Map<String, Any>): ApiResponse<QuizAttempt>
}
