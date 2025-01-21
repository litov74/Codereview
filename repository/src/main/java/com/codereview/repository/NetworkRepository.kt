package com.codereview.repository

import kotlinx.coroutines.flow.Flow

interface NetworkRepository {
    fun getVacancyList(limit: Int = 10): Flow<List<Vacancy>>
    fun getVacancyDetails(id: Int): Flow<Vacancy>
}