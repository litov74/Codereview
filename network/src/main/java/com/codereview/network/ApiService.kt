package com.codereview.network

import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("api/jobs/")
    suspend fun readVacancies(
        @Query("limit") limit: Int
    ): List<VacancyNet>

    @GET("api/jobs/")
    suspend fun readVacancy(
        @Query("vacancy_id") vacancyId: Int
    ): VacancyNet
}