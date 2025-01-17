package com.codereview.network

import javax.inject.Inject

class NetworkRepository @Inject constructor(private val apiService: ApiService) {

    suspend fun getVacancies(limit: Int = 10): List<VacancyNet>? {
        return try {
            apiService.readVacancies(limit)
        } catch (e: Exception) {
            null
        }
    }

    suspend fun getVacancy(id: Int): VacancyNet? {
        return try {
            apiService.readVacancy(id)
        } catch (e: Exception) {
            null
        }
    }
}