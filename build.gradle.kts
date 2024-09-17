plugins {
	kotlin("jvm") version "2.0.20"
	id("io.ktor.plugin") version "2.3.12"
	id("org.jetbrains.kotlin.plugin.serialization") version "2.0.20"
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
	implementation("ch.qos.logback:logback-classic:1.5.8")
	implementation("commons-codec:commons-codec:1.17.1")
	implementation("org.litote.kmongo:kmongo:5.1.0")
	implementation("org.litote.kmongo:kmongo-coroutine:5.1.0")
}

repositories {
	mavenCentral()
}
