package me.luki.data.model.user

import org.bson.types.ObjectId

interface UserDataSource {
    suspend fun getUserByUsername(username: String): User?
    suspend fun insertUser(user: User): Boolean
    suspend fun deleteUserWithId(id: ObjectId): Boolean
    suspend fun userExistsInDatabase(id: ObjectId): Boolean
}
