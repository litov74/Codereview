package com.codereview.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override fun getVacancyList(limit: Int): Flow<List<VacancyNet>> = flow {
        emit(apiService.readVacancies(limit))
    }

    override fun getVacancyDetails(id: Int): Flow<VacancyNet> = flow {
        emit(apiService.readVacancy(id))
    }
}