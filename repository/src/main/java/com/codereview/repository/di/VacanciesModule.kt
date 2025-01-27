package com.codereview.repository.di

import com.codereview.repository.vacancy_repository.VacancyRepository
import com.codereview.repository.vacancy_repository.VacancyRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface VacanciesModule {

    @Binds
    fun bindVacancyRepository(impl: VacancyRepositoryImpl): VacancyRepository

}