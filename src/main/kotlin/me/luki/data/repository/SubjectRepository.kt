package me.luki.data.repository

import me.luki.data.model.Subject

interface SubjectRepository {
	suspend fun getSubjects(): List<Subject>
}
