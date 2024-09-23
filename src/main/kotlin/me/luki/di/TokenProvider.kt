package me.luki.di

import me.luki.security.token.JwtTokenService
import me.luki.security.token.TokenService

object TokenProvider {
    fun provideTokenService(): TokenService = JwtTokenService()
}
