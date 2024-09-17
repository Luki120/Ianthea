package me.luki.data.repository

import me.luki.data.model.subject.Subject

interface SubjectRepository {
	suspend fun getSubjects(): List<Subject>
}
