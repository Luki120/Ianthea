package com.luki.plugins

import com.luki.di.SubjectProvider
import com.luki.routes.subjects
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
	routing {
		subjects(repository = SubjectProvider.provideSubjectRepository())
	}
}
