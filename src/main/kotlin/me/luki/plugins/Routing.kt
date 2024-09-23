package me.luki.plugins

import com.mongodb.kotlin.client.coroutine.MongoDatabase
import io.ktor.server.application.*
import io.ktor.server.routing.*
import me.luki.di.*
import me.luki.routes.*

fun Application.configureRouting(database: MongoDatabase, environment: ApplicationEnvironment) {
	routing {
		subjects(repository = SubjectProvider.provideSubjectRepository())

		val hashingProvider = HashingProvider.provideHashingService()
		val userProvider = UserProvider.provideUserDataSource(database = database)

		signIn(
			userDataSource = userProvider,
			hashingService = hashingProvider,
			tokenService = TokenProvider.provideTokenService(),
			tokenConfig = TokenConfigProvider.provideTokenConfig(environment = environment)
		)
		signUp(hashingService = hashingProvider, userDataSource = userProvider)
		deleteUser(userDataSource = userProvider)
		authenticate()
		getSecretInfo()
	}
}
