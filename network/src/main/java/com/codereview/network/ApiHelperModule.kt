package com.codereview.network

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface ApiHelperModule {

    @Singleton
    @Binds
    fun bindApiHelper(impl: ApiHelperImpl): ApiHelper

}