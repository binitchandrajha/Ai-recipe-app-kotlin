package com.example.ai_recipe_app_kotlin.model.network

import kotlinx.serialization.Serializable

@Serializable
data class SendOtpRequest(
    val countryCode: String,
    val mobileNumber: String
)

@Serializable
data class SendOtpData(
    val countryCode: String,
    val mobileNumber: String,
    val devOtp: String
)

@Serializable
data class VerifyOtpRequest(
    val countryCode: String,
    val mobileNumber: String,
    val code: String
)

@Serializable
data class UserData(
    val id: String,
    val countryCode: String,
    val mobileNumber: String,
    val name: String? = null,
    val profileImage: String? = null,
    val onboardingCompleted: Boolean,
    val profileSetupDone: Boolean,
    val createdAt: String,
    val updatedAt: String
)

@Serializable
data class VerifyOtpData(
    val token: String,
    val isNewUser: Boolean,
    val user: UserData
)