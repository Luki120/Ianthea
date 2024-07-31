package com.luki.data.model

import kotlinx.serialization.Serializable

@Serializable
data class Subject(
	val name: String,
	val year: String,
	val grade: Int? = null,
	val isFinished: Boolean = false
)
