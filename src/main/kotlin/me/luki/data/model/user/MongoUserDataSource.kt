package me.luki.data.model.user

import com.mongodb.client.model.Filters.eq
import com.mongodb.kotlin.client.coroutine.MongoDatabase
import kotlinx.coroutines.flow.firstOrNull

class MongoUserDataSource(database: MongoDatabase): UserDataSource {
    private val users = database.getCollection<User>("users")

    override suspend fun getUserByUsername(username: String): User? {
        return users.find(eq(User::username.name, username)).firstOrNull()
    }

    override suspend fun insertUser(user: User): Boolean {
        return users.insertOne(user).wasAcknowledged()
    }
}
