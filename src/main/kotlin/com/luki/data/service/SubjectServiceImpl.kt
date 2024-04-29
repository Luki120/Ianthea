package com.luki.data.service

import com.luki.data.model.Subject

class SubjectServiceImpl: SubjectService {

	override suspend fun getSubjects(): List<Subject> {
		return listOf(
			Subject(name = "Anatomy", year = "First"),
			Subject(name = "Histology, Cellular Biology, Embryology & Genetics", year = "First"),
			Subject(name = "Mental Health", year = "First"),
			Subject(name = "Bioethics I", year = "First"),
			Subject(name = "Physiology", year = "Second"),
			Subject(name = "Biochemistry", year = "Second"),
			Subject(name = "Immunology", year = "Third"),
			Subject(name = "Microbiology I", year = "Third"),
			Subject(name = "Microbiology II", year = "Third"),
			Subject(name = "Pharmacology", year = "Third"),
			Subject(name = "Pathology", year = "Third"),
			Subject(name = "Pathology II", year = "Fourth"),
			Subject(name = "Semiology", year = "Fourth"),
			Subject(name = "Public Health I", year = "Fourth"),
			Subject(name = "Public Health II", year = "Fifth, Sixth"),
			Subject(name = "Bioethics II", year = "Fifth, Sixth"),
			Subject(name = "Pharmacology II", year = "Fifth, Sixth"),
			Subject(name = "Toxicology", year = "Fifth, Sixth"),
			Subject(name = "Legal Medicine", year = "Fifth, Sixth"),
			Subject(name = "Internal Medicine", year = "Fifth, Sixth"),
			Subject(name = "Psychiatry", year = "Fifth, Sixth"),
			Subject(name = "Nutrition", year = "Fifth, Sixth"),
			Subject(name = "Diagnostic Imaging", year = "Fifth, Sixth"),
			Subject(name = "Dermatology", year = "Fifth, Sixth"),
			Subject(name = "Infectology", year = "Fifth, Sixth"),
			Subject(name = "Pneumonology", year = "Fifth, Sixth"),
			Subject(name = "Neurology", year = "Fifth, Sixth"),
			Subject(name = "General Surgery", year = "Fifth, Sixth"),
			Subject(name = "Urology", year = "Fifth, Sixth"),
			Subject(name = "Traumatology", year = "Fifth, Sixth"),
			Subject(name = "Ophthalmology", year = "Fifth, Sixth"),
			Subject(name = "Otorhinolaryngology", year = "Fifth, Sixth"),
			Subject(name = "Neurosurgery", year = "Fifth, Sixth"),
			Subject(name = "Obstetrics", year = "Fifth, Sixth"),
			Subject(name = "Gynecology", year = "Fifth, Sixth"),
			Subject(name = "Pediatrics", year = "Fifth, Sixth"),
			Subject(name = "Family Medicine", year = "Fifth, Sixth")
		)
	}

}
