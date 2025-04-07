package com.codereview.repository.locations_repository

import com.codereview.network.ApiHelper
import com.codereview.network.Locations
import com.codereview.repository.jobs_repository.JobSpec
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.filter
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.flow.map
import javax.inject.Inject

class LocationRepositoryImpl @Inject constructor(private val apiHelper: ApiHelper) : LocationRepository {


    override fun getLocations() = flow {
        val locations = apiHelper.getLocations().map { value ->
            value.data }
        emitAll(locations)
    }

    override fun getSpecialities(): Flow<ArrayList<String?>> = flow {
            val jobList:ArrayList<String?> = arrayListOf(
                JobSpec.PYTHON.jobTitle,
                JobSpec.JAVA.jobTitle,
                JobSpec.JAVASCRIPT.jobTitle,
                JobSpec.DATASCIENCE.jobTitle,
                JobSpec.QA.jobTitle,
                JobSpec.CSHARP.jobTitle
            )
        emit(jobList)
    }
}