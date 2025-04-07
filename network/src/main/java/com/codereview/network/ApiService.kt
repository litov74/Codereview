package com.codereview.network

import com.codereview.network.model.VacancyList
import com.codereview.network.model.VacancyNet
import kotlinx.serialization.InternalSerializationApi
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @OptIn(InternalSerializationApi::class)
    @GET("jobs/")
    suspend fun getVacancies(
        @Query("skip") skip: Int = 0,
        @Query("limit") limit: Int = 100,
        @Query("specialities") specialities: String,
    ): VacancyList

    @OptIn(InternalSerializationApi::class)
    @GET("jobs/{vacancy_id}")
    suspend fun getVacancy(
        @Path("vacancy_id") vacancyId: String
    ): VacancyNet
}