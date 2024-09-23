package me.luki.di

import me.luki.security.hashing.HashingService
import me.luki.security.hashing.SHA256HashingService

object HashingProvider {
    fun provideHashingService(): HashingService = SHA256HashingService()
}
