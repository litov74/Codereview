package com.codereview.network

import com.codereview.network.model.VacanciesNet
import com.codereview.network.model.VacancyNet
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("jobs/")
    suspend fun readVacancies(
        @Query("skip") skip: Int = 0,
        @Query("limit") limit: Int = 100,
        @Query("specialities") specialities: String,
    ): VacanciesNet

    @GET("api/jobs/{vacancy_id}")
    suspend fun readVacancy(
        @Path("vacancy_id") vacancyId: Int
    ): VacancyNet
}