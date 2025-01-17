package com.codereview.network

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

interface ApiHelper {
    fun getVacancies(limit: Int = 10): Flow<List<VacancyNet>>
    fun getVacancy(id: Int): Flow<VacancyNet>
}

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {

    override fun getVacancies(limit: Int): Flow<List<VacancyNet>> = flow {
        emit(apiService.readVacancies(limit))
    }

    override fun getVacancy(id: Int): Flow<VacancyNet> = flow {
        emit(apiService.readVacancy(id))
    }
}