package me.luki.routes

import io.ktor.http.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import me.luki.data.repository.SubjectRepository

fun Route.subjects(repository: SubjectRepository) {
	get("/") {
		call.respondText("Nothing here bozo \n\n© 2024 Luki120")
	}

	get("/v1/subjects") {
		call.respond(HttpStatusCode.OK, repository.getSubjects())
	}
}
