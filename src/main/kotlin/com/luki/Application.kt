package com.luki

import com.luki.plugins.configureMonitoring
import com.luki.plugins.configureRouting
import com.luki.plugins.configureSerialization
import io.ktor.server.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
	configureSerialization()
	configureMonitoring()
	configureRouting()
}
