package com.codereview.network

import com.codereview.network.model.VacancyNet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    override fun getVacancyList(
        limit: Int,
        specialities: String,
    ): Flow<List<VacancyNet>> = flow {
        val vacancyList = apiService.readVacancies(limit = limit,specialities = specialities)
        emit(vacancyList.data)
    }

    override fun getVacancyDetails(id: Int): Flow<VacancyNet> = flow {
        emit(apiService.readVacancy(id))
    }
}