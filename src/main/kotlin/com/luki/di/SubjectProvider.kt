package com.luki.di

import com.luki.data.repository.SubjectRepository
import com.luki.data.repository.SubjectRepositoryImpl
import com.luki.data.service.SubjectServiceImpl

object SubjectProvider {
	fun provideSubjectRepository(): SubjectRepository = SubjectRepositoryImpl(SubjectServiceImpl())
}
