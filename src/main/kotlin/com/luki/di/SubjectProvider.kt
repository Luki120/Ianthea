package com.luki.di

import com.luki.data.repository.SubjectRepository
import com.luki.data.repository.SubjectRepositoryImpl

object SubjectProvider {
	fun provideSubjectRepository(): SubjectRepository = SubjectRepositoryImpl()
}
