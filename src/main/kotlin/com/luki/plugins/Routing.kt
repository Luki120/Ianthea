package com.luki.plugins

import com.luki.routes.subjects
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
	routing {
		subjects()
	}
}
