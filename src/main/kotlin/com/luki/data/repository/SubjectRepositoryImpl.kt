package com.luki.data.repository

import com.luki.data.model.Subject
import com.luki.data.service.SubjectService

class SubjectRepositoryImpl(private val subjectService: SubjectService): SubjectRepository {

	override suspend fun getSubjects(): List<Subject> {
		return subjectService.getSubjects()
	}

}
