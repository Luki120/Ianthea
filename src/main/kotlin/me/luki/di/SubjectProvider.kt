package me.luki.di

import me.luki.data.repository.SubjectRepository
import me.luki.data.repository.SubjectRepositoryImpl

object SubjectProvider {
	fun provideSubjectRepository(): SubjectRepository = SubjectRepositoryImpl()
}
