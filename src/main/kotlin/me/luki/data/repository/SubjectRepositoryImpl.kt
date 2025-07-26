package me.luki.data.repository

import me.luki.data.model.subject.Subject

class SubjectRepositoryImpl: SubjectRepository {
	override suspend fun getSubjects(): List<Subject> {
		return listOf(
			Subject(name = "Anatomy", year = "First", shortName = "Anato", hasThreeExams = true),
			Subject(name = "HyE", year = "First"),
			Subject(name = "Mental Health", year = "First", shortName = "SM"),
			Subject(name = "Bioethics", year = "First", shortName = "Bioética"),
			Subject(name = "Physiology", year = "Second", shortName = "Fisio"),
			Subject(name = "Biochemistry", year = "Second", shortName = "Bioqui", hasThreeExams = true),
			Subject(name = "Immunology", year = "Third", shortName = "Inmuno"),
			Subject(name = "Microbiology", year = "Third", shortName = "Micro"),
			Subject(name = "Microbiology II", year = "Third", shortName = "Micro II"),
			Subject(name = "Pharmacology", year = "Third", shortName = "Fármaco"),
			Subject(name = "Pathology", year = "Third", shortName = "Pato"),
			Subject(name = "Pathology II", year = "Fourth", shortName = "Pato II"),
			Subject(name = "Semiology", year = "Fourth", shortName = "Semio"),
			Subject(name = "Public Health", year = "Fourth", shortName = "SP"),
			Subject(name = "Pharmacology II", year = "Fifth", shortName = "Fármaco II"),
			Subject(name = "Toxicology", year = "Fifth", shortName = "Tóxico"),
			Subject(name = "Legal Medicine", year = "Fifth", shortName = "Legal"),
			Subject(name = "Internal Medicine", year = "Fifth", shortName = "Interna"),
			Subject(name = "Psychiatry", year = "Fifth"),
			Subject(name = "Nutrition", year = "Fifth"),
			Subject(name = "Diagnostic Imaging", year = "Fifth", shortName = "Dx img"),
			Subject(name = "Dermatology", year = "Fifth", shortName = "Dermato"),
			Subject(name = "Infectology", year = "Fifth", shortName = "Infecto"),
			Subject(name = "Pneumonology", year = "Fifth", shortName = "Neumo"),
			Subject(name = "Neurology", year = "Fifth", shortName = "Neuro"),
			Subject(name = "General Surgery", year = "Sixth", shortName = "Cirugía"),
			Subject(name = "Urology", year = "Sixth"),
			Subject(name = "Traumatology", year = "Sixth", shortName = "Traumato"),
			Subject(name = "Ophthalmology", year = "Sixth", shortName = "Oftalmo"),
			Subject(name = "Otorhinolaryngology", year = "Sixth", shortName = "Otorrino"),
			Subject(name = "Neurosurgery", year = "Sixth", shortName = "Neurocx"),
			Subject(name = "Obstetrics", year = "Sixth"),
			Subject(name = "Gynecology", year = "Sixth", shortName = "Gineco"),
			Subject(name = "Pediatrics", year = "Sixth", shortName = "Pediatría"),
			Subject(name = "Family Medicine", year = "Sixth", shortName = "Familiar")
		)
	}
}
