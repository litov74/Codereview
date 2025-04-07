package com.codereview.network

import com.codereview.network.model.VacancyList
import com.codereview.network.model.VacancyNet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.serialization.InternalSerializationApi
import javax.inject.Inject

class ApiHelperImpl @Inject constructor(private val apiService: ApiService) : ApiHelper {
    @OptIn(InternalSerializationApi::class)
    override fun getVacancyList(
        limit: Int,
        specialities: String,
    ): Flow<VacancyList> = flow {
        val vacancyList = apiService.getVacancies(limit = limit,specialities = specialities)
        emit(vacancyList)
    }

    @OptIn(InternalSerializationApi::class)
    override fun getVacancyDetails(id: String): Flow<VacancyNet> = flow {
        emit(apiService.getVacancy(id))
    }
}