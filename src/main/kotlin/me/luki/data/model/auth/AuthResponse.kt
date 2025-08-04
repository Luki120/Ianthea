package me.luki.data.model.auth

import kotlinx.serialization.Serializable

@Serializable
data class AuthResponse(val token: String)
