package com.luki.data.service

import com.luki.data.model.Subject

interface SubjectService {
	suspend fun getSubjects(): List<Subject>
}
