package com.codereview.repository.vacancy_repository

import kotlinx.coroutines.flow.Flow

interface VacancyRepository {
    fun getVacancyList(limit: Int = 10): Flow<List<Vacancy>>
    fun getVacancyDetails(id: Int): Flow<Vacancy>
}