package me.luki.plugins

import me.luki.di.SubjectProvider
import me.luki.routes.subjects
import io.ktor.server.application.*
import io.ktor.server.routing.*

fun Application.configureRouting() {
	routing {
		subjects(repository = SubjectProvider.provideSubjectRepository())
	}
}
