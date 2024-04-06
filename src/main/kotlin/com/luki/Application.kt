package com.luki

import com.luki.plugins.*
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main(args: Array<String>): Unit = EngineMain.main(args)

fun Application.module() {
	configureSerialization()
	configureMonitoring()
	configureRouting()
}
