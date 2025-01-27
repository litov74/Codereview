package com.codereview.network

import kotlinx.coroutines.flow.Flow

interface ApiHelper {
    fun getVacancyList(limit: Int = 10): Flow<List<VacancyNet>>
    fun getVacancyDetails(id: Int): Flow<VacancyNet>
}