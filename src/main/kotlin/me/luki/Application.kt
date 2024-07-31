package me.luki

import me.luki.plugins.configureMonitoring
import me.luki.plugins.configureRouting
import me.luki.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
	configureSerialization()
	configureMonitoring()
	configureRouting()
}
