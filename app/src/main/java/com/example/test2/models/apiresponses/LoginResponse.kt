package com.example.test2.models.apiresponses

import java.io.Serializable

data class LoginResponse(val success:Boolean, val token: String) : Serializable
