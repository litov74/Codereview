package com.codereview.repository.di

import com.codereview.repository.jobs_repository.JobRepository
import com.codereview.repository.jobs_repository.JobRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface JobsModule {

    @Binds
    fun bindJobRepository(impl: JobRepositoryImpl): JobRepository
}