package com.codereview.repository.vacancy_repository

import com.codereview.network.ApiHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VacancyRepositoryImpl @Inject constructor(private val apiHelper: ApiHelper) :
    VacancyRepository {

    override fun getVacancyList(
        limit: Int,
        specialities: String,
    ): Flow<List<Vacancy>> = flow {
        val vacancies = apiHelper.getVacancyList(
            limit = limit,
            specialities = specialities
        ).map { vacancyNetList ->
            vacancyNetList.data.map { vacancyNetItem -> vacancyNetItem.toVacancy() }
        }
        emitAll(vacancies)
    }

    override fun getVacancyDetails(id: Int): Flow<Vacancy> = flow {
        val vacancy = apiHelper.getVacancyDetails(id).map { vacancyNet -> vacancyNet.toVacancy() }
        emitAll(vacancy)
    }
}