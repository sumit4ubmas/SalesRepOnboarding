package com.plum.salesacademy.data.model

data class ApiResponse<T>(val status: String, val message: String, val data: T?)
data class User(val userId: String, val fullName: String, val email: String, val phone: String, val role: String, val certifiedStatus: String)
data class TrainingModule(val moduleId: String, val trainingType: String, val moduleTitle: String, val moduleOrder: Int, val estimatedMinutes: Int, val requiredFlag: Boolean)
data class QuizAttempt(val attemptId: String, val userId: String, val percentScore: Double, val passFail: String, val attemptNo: Int, val certificateId: String?)
