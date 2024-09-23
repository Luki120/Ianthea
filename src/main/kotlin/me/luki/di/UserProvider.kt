package me.luki.di

import com.mongodb.kotlin.client.coroutine.MongoDatabase
import me.luki.data.model.user.MongoUserDataSource
import me.luki.data.model.user.UserDataSource

object UserProvider {
    fun provideUserDataSource(database: MongoDatabase): UserDataSource = MongoUserDataSource(database)
}
