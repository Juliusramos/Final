package com.firstapp.loginactivity

data class TwilioResponse(
    val sid: String?,
    val serviceSid: String?,
    val to: String?,
    val status: String?,
    val valid: Boolean?
)