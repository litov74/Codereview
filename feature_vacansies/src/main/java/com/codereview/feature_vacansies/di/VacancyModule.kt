package com.codereview.feature_vacansies.di


import com.codereview.feature_vacansies.data.VacancyRepoImpl
import com.codereview.feature_vacansies.data.VacancyRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface VacancyModule {
    @Binds
    fun providesVacancyRepository(impl: VacancyRepoImpl): VacancyRepository
}