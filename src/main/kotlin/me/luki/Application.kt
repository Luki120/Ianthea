package me.luki

import com.mongodb.kotlin.client.coroutine.MongoClient
import io.ktor.server.application.*
import io.ktor.server.netty.*
import me.luki.data.model.user.MongoUserDataSource
import me.luki.plugins.configureMonitoring
import me.luki.plugins.configureRouting
import me.luki.plugins.configureSecurity
import me.luki.plugins.configureSerialization
import me.luki.security.hashing.SHA256HashingService
import me.luki.security.token.JwtTokenService
import me.luki.security.token.TokenConfig

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
	val password = System.getenv("mongoPassword")
	val connectionString = "mongodb+srv://lukimaine120:$password@iantheadb.w54r9.mongodb.net/?retryWrites=true&w=majority&appName=IantheaDB"

	val database = MongoClient.create(connectionString = connectionString).getDatabase("IantheaDB")

	val userDataSource = MongoUserDataSource(database = database)
	val hashingService = SHA256HashingService()
	val tokenService = JwtTokenService()

	val tokenConfig = TokenConfig(
		issuer = environment.config.property("jwt.issuer").getString(),
		audience = environment.config.property("jwt.audience").getString(),
		expiresIn = System.currentTimeMillis() + 365L * 1000L * 60L * 60L * 24L,
		secret = System.getenv("JWTSecret")
	)

	configureSecurity(config = tokenConfig)
	configureSerialization()
	configureMonitoring()
	configureRouting(userDataSource, hashingService, tokenService, tokenConfig)
}
