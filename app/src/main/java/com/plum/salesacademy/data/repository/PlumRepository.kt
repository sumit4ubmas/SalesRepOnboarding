package com.plum.salesacademy.data.repository

import com.plum.salesacademy.data.remote.ApiService

class PlumRepository(private val api: ApiService) {
    suspend fun login(identifier: String) = api.loginUser(mapOf("identifier" to identifier))
    suspend fun verifyOtp(identifier: String, otp: String) = api.verifyOtp(mapOf("identifier" to identifier, "otp" to otp))
    suspend fun trainingModules(trainingType: String) = api.getTrainingModules(mapOf("trainingType" to trainingType))
}
