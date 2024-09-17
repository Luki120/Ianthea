package me.luki.plugins

import io.ktor.server.application.*
import io.ktor.server.routing.*
import me.luki.data.model.user.UserDataSource
import me.luki.di.SubjectProvider
import me.luki.routes.*
import me.luki.security.hashing.HashingService
import me.luki.security.token.TokenConfig
import me.luki.security.token.TokenService

fun Application.configureRouting(
    userDataSource: UserDataSource,
    hashingService: HashingService,
    tokenService: TokenService,
    tokenConfig: TokenConfig,
) {
	routing {
		subjects(repository = SubjectProvider.provideSubjectRepository())
		signIn(userDataSource, hashingService, tokenService, tokenConfig)
		signUp(hashingService, userDataSource)
		authenticate()
		getSecretInfo()
	}
}
