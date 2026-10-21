plugins {
	kotlin("jvm") version "2.4.21"
	id("io.ktor.plugin") version "3.6.0"
	id("org.jetbrains.kotlin.plugin.serialization") version "2.4.21"
}

group = "me.luki"
version = "0.9.0"

application {
	mainClass.set("io.ktor.server.netty.EngineMain")

	val isDevelopment = project.ext.has("development")
	applicationDefaultJvmArgs = listOf("-Dio.ktor.development=$isDevelopment")
}

dependencies {
	implementation("io.ktor:ktor-serialization-kotlinx-json-jvm")
	implementation("io.ktor:ktor-server-auth-jvm")
	implementation("io.ktor:ktor-server-auth-jwt-jvm")
	implementation("io.ktor:ktor-server-core-jvm")
	implementation("io.ktor:ktor-server-call-logging-jvm")
	implementation("io.ktor:ktor-server-content-negotiation-jvm")
	implementation("io.ktor:ktor-server-host-common-jvm")
	implementation("io.ktor:ktor-server-netty-jvm")
	implementation("ch.qos.logback:logback-classic:1.6.5")
	implementation("commons-codec:commons-codec:1.23.0")
	implementation("org.mongodb:mongodb-driver-kotlin-coroutine:5.13.0")
}

repositories {
	mavenCentral()
}
