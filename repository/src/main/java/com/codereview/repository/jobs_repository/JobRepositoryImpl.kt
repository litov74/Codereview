package com.codereview.repository.jobs_repository

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JobRepositoryImpl @Inject constructor() : JobRepository {

    override fun getJobList(): Flow<List<JobSpec>> = flow {
        val jobList = listOf(
            JobSpec.PYTHON,
            JobSpec.JAVA,
            JobSpec.JAVASCRIPT,
            JobSpec.DATASCIENCE,
            JobSpec.QA,
            JobSpec.CSHARP
        )

        emit(jobList)
    }
}