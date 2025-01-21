package com.codereview.repository

import com.codereview.network.ApiHelper
import com.codereview.network.VacancyNet
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject

interface NetworkRepository {
    fun getVacancies(limit: Int = 10): Flow<List<Vacancy>>
    fun getVacancy(id: Int): Flow<Vacancy>
}

class NetworkRepositoryImpl @Inject constructor(private val apiHelper: ApiHelper) : NetworkRepository {

    override fun getVacancies(limit: Int): Flow<List<Vacancy>> = flow {
        val vacancies = apiHelper.getVacancies(limit).map { vacancyNetList ->
            vacancyNetList.map { vacancyNetItem -> vacancyNetItem.toVacancy() }
        }
        emitAll(vacancies)
    }

    override fun getVacancy(id: Int): Flow<Vacancy> = flow {
        val vacancy = apiHelper.getVacancy(id).map { vacancyNet -> vacancyNet.toVacancy() }
        emitAll(vacancy)
    }

    private fun VacancyNet.toVacancy(): Vacancy = Vacancy(
        id = id ?: 0,
        active = active ?: false,
        companyName = companyName.orEmpty(),
        salary = salary.orEmpty(),
        speciality = speciality.orEmpty(),
        remote = remote ?: false,
        url = url.orEmpty(),
        description = description.orEmpty(),
        title = title.toString(),
        externalId = externalId ?: 0,
        location = location.orEmpty(),
        internship = internship ?: false
    )
}