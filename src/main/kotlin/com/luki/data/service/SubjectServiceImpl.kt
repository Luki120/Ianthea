package com.luki.data.service

import com.luki.data.model.Subject
import com.luki.data.service.SubjectService

class SubjectServiceImpl: SubjectService {

	override suspend fun getSubjects(): List<Subject> {
		return listOf(
			Subject(name = "Anatomy", year = "First"),
			Subject(name = "Histology, Cellular Biology, Embryology & Genetics", year = "First"),
			Subject(name = "Mental Health", year = "First"),
			Subject(name = "Physiology", year = "Second"),
			Subject(name = "Biochemistry", year = "Second")
		)
	}

}
