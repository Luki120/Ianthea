package me.luki.security.hashing

interface HashingService {
    fun generateSaltedHash(value: String, saltLength: Int = 32): SaltedHash
    fun verifyHash(value: String, saltedHash: SaltedHash): Boolean
}
