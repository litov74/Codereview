package com.codereview.repository.vacancy_repository

import com.codereview.network.ApiHelper
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class VacancyRepositoryImpl @Inject constructor(private val apiHelper: ApiHelper) :
    VacancyRepository {

    override fun getVacancyList(limit: Int): Flow<List<Vacancy>> = flow {
        val vacancies = apiHelper.getVacancyList(limit).map { vacancyNetList ->
            vacancyNetList.map { vacancyNetItem -> vacancyNetItem.toVacancy() }
        }
        emitAll(vacancies)
    }

    override fun getVacancyDetails(id: Int): Flow<Vacancy> = flow {
        val vacancy = apiHelper.getVacancyDetails(id).map { vacancyNet -> vacancyNet.toVacancy() }
        emitAll(vacancy)
    }
}