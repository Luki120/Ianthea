package me.luki.di

import io.ktor.server.application.*
import me.luki.security.token.TokenConfig

object TokenConfigProvider {
    fun provideTokenConfig(environment: ApplicationEnvironment): TokenConfig {
        return TokenConfig(
            issuer = environment.config.property("jwt.issuer").getString(),
            audience = environment.config.property("jwt.audience").getString(),
            expiresIn = System.currentTimeMillis() + 180L * 1000L * 60L * 60L * 24L,
            secret = System.getenv("JWTSecret")
        )
    }
}
