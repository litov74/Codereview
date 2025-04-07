package com.codereview.network

import com.codereview.network.model.VacancyList
import com.codereview.network.model.VacancyNet
import kotlinx.coroutines.flow.Flow
import kotlinx.serialization.InternalSerializationApi

interface ApiHelper {

    @OptIn(InternalSerializationApi::class)
    fun getVacancyList(
        limit: Int = 100,
        specialities: String,
    ): Flow<VacancyList>

    @OptIn(InternalSerializationApi::class)
    fun getVacancyDetails(id: String): Flow<VacancyNet>
}