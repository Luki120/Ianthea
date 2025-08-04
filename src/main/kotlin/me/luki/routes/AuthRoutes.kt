package me.luki.routes

import io.ktor.http.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.luki.data.model.user.User
import me.luki.data.model.user.UserDataSource
import me.luki.data.model.auth.AuthRequest
import me.luki.data.model.auth.AuthResponse
import me.luki.security.hashing.HashingService
import me.luki.security.hashing.SaltedHash
import me.luki.security.token.TokenClaim
import me.luki.security.token.TokenConfig
import me.luki.security.token.TokenService
import org.apache.commons.codec.digest.DigestUtils
import org.bson.types.ObjectId
import org.slf4j.LoggerFactory

private val logger = LoggerFactory.getLogger("IantheaLogger")

private object AuthError {
    const val BAD_REQUEST = "Invalid request"
    const val INCORRECT_DATA = "Incorrect username or password"
    const val USER_INSERTION_FAILED = "Something went wrong when trying to insert a user to the database"
    const val USER_DELETION_FAILED = "Something went wrong when trying to delete a user from the database"
    const val USER_NOT_FOUND = "This user does not exist in the database"
}

fun Route.signUp(hashingService: HashingService, userDataSource: UserDataSource) {
    post("/v1/auth/signup") {
        val request = call.receiveNullable<AuthRequest>()
        if (request == null) {
            call.respond(HttpStatusCode.BadRequest, AuthError.BAD_REQUEST)
            return@post
        }

        val saltedHash = hashingService.generateSaltedHash(value = request.password)

        val user = User(
            username = request.username,
            password = saltedHash.hash,
            salt = saltedHash.salt
        )
        val wasAcknowledged = userDataSource.insertUser(user)

        if (!wasAcknowledged) {
            call.respond(HttpStatusCode.Conflict, AuthError.USER_INSERTION_FAILED)
            logger.error(AuthError.USER_INSERTION_FAILED)
            return@post
        }
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.signIn(
    userDataSource: UserDataSource,
    hashingService: HashingService,
    tokenService: TokenService,
    tokenConfig: TokenConfig
) {
    post("/v1/auth/signin") {
        val request = call.receiveNullable<AuthRequest>()

        if (request == null) {
            call.respond(HttpStatusCode.BadRequest, AuthError.BAD_REQUEST)
            return@post
        }

        val user = userDataSource.getUserByUsername(request.username)
        if (user == null) {
            call.respond(HttpStatusCode.Conflict, message = AuthError.INCORRECT_DATA)
            logger.error(AuthError.INCORRECT_DATA)
            return@post
        }
        val isValidPassword = hashingService.verifyHash(
            value = request.password,
            saltedHash = SaltedHash(hash = user.password, salt = user.salt)
        )

        if (!isValidPassword) {
            call.respond(HttpStatusCode.Conflict, AuthError.INCORRECT_DATA)
            logger.error(AuthError.INCORRECT_DATA)

            println("Entered hash: ${DigestUtils.sha256Hex("${user.salt}${request.password}")}, Hashed PW: ${user.password}")
            return@post
        }

        val token = tokenService.generate(
            config = tokenConfig,
            TokenClaim(name = "userId", value = user.id.toString())
        )
        call.respond(HttpStatusCode.OK, AuthResponse(token = token))
    }
}

fun Route.deleteUser(userDataSource: UserDataSource) {
    delete("/v1/auth/users/{id}") {
        val userId = call.parameters["id"]

        if (userId.isNullOrEmpty()) {
            call.respond(HttpStatusCode.BadRequest, AuthError.BAD_REQUEST)
            return@delete
        }

        val userExists = userDataSource.userExistsInDatabase(ObjectId(userId))
        if (!userExists) {
            call.respond(HttpStatusCode.NotFound, AuthError.USER_NOT_FOUND)
            logger.error(AuthError.USER_NOT_FOUND)
            return@delete
        }

        val wasAcknowledged = userDataSource.deleteUserWithId(ObjectId(userId))
        if(!wasAcknowledged) {
            call.respond(HttpStatusCode.Conflict, AuthError.USER_DELETION_FAILED)
            logger.error(AuthError.USER_DELETION_FAILED)
            return@delete
        }
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.authenticate() {
    authenticate {
        get("/v1/auth/authenticate") {
            call.respond(HttpStatusCode.OK)
        }
    }
}

fun Route.getSecretInfo() {
    authenticate {
        get("/v1/auth/secret") {
            val principal = call.principal<JWTPrincipal>()
            val userId = principal?.getClaim("userId", String::class)
            call.respond(HttpStatusCode.OK, "$userId")
        }
    }
}
