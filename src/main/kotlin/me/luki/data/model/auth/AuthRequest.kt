package me.luki.data.model.auth

import kotlinx.serialization.Serializable

@Serializable
data class AuthRequest(val username: String, val password: String)
