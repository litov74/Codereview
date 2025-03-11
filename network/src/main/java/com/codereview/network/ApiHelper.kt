package com.codereview.network

import com.codereview.network.model.VacancyList
import com.codereview.network.model.VacancyNet
import kotlinx.coroutines.flow.Flow

interface ApiHelper {

    fun getVacancyList(
        limit: Int = 100,
        specialities: String,
    ): Flow<VacancyList>

    fun getVacancyDetails(id: Int): Flow<VacancyNet>
}