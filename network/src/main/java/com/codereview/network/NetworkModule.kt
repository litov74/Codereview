package com.codereview.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    private const val BASE_URL = "http://194.87.151.162:8000/"

    @Provides
    @Singleton
    fun retrofitInit() : Retrofit {
        return Retrofit.Builder()
            .baseUrl(BASE_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
    }

    @Provides
    @Singleton
    fun getApiService(retrofit: Retrofit): ApiService {
        return retrofit.create(ApiService::class.java)
    }
}

interface ApiService {
    @GET("api/jobs/")
    suspend fun readVacancies(
        @Query("limit") limit: Int
    ): List<VacancyNet> // OR return Vacancy from feature_vacansies?

    @GET("api/jobs/")
    suspend fun readVacancy(
        @Query("vacancy_id") vacancyId: Int
    ): VacancyNet
}