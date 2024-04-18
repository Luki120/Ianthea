package com.luki.routes

import com.luki.data.model.Subject
import com.luki.data.repository.SubjectRepository
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.subjects(repository: SubjectRepository) {
	get("/") {
		call.respondText("Nothing here bozo \n\n© 2024 Luki120")
	}

	get("/v1/subjects") {
		call.respond(HttpStatusCode.OK, repository.getSubjects())
	}
}
