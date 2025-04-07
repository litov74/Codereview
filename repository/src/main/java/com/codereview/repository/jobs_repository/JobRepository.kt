package com.codereview.repository.jobs_repository

import kotlinx.coroutines.flow.Flow

interface JobRepository {
    fun getJobList(): Flow<List<JobSpec>>
}