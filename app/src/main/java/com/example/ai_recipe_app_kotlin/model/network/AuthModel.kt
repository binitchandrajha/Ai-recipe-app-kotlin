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