package com.codereview.repository.locations_repository

import com.codereview.network.Locations
import com.codereview.repository.jobs_repository.JobSpec
import kotlinx.coroutines.flow.Flow

interface LocationRepository {
    fun getLocations(): Flow<ArrayList<String?>>
    fun getSpecialities(): Flow<ArrayList<String?>>
}