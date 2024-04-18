package com.luki.data.repository

import com.luki.data.model.Subject

interface SubjectRepository {
	suspend fun getSubjects(): List<Subject>
}
