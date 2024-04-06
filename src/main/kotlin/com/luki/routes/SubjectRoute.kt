package com.luki.routes

import com.luki.data.model.Subject
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

private val subjects = listOf(
	Subject("Anatomy", "First"),
	Subject("Histology, Cellular Biology, Embryology & Genetics", "First"),
	Subject("Mental Health", "First"),
	Subject("Physiology", "Second"),
	Subject("Biochemistry", "Second")
)

fun Route.subjects() {
	get("/") {
		call.respondText("Nothing here bozo \n\n© 2024 Luki120")
	}
	get("/subjects") {
		call.respond(
			HttpStatusCode.OK,
			subjects
		)
	}
}
