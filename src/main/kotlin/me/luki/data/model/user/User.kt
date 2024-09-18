package me.luki.data.model.user

import kotlinx.serialization.Contextual
import kotlinx.serialization.SerialName
import org.bson.types.ObjectId

data class User(
    val username: String,
    val password: String,
    val salt: String,
    @SerialName("_id")
    @Contextual val id: ObjectId = ObjectId()
)
