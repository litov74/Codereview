package com.codereview.repository.di

import com.codereview.repository.locations_repository.LocationRepository
import com.codereview.repository.locations_repository.LocationRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface LocationsModule {
    @Binds
    fun bindLocationsRepository(impl: LocationRepositoryImpl): LocationRepository
}