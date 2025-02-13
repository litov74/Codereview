package com.codereview.repository.jobs_repository

import com.codereview.core.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JobRepositoryImpl @Inject constructor() : JobRepository {

    override fun getJobList(): Flow<List<JobSpec>> = flow {
        val jobList = listOf(
            JobSpec("Python", "python", R.drawable.python),
            JobSpec("Java", "java", R.drawable.java),
            JobSpec("JavaScript", "javascript", R.drawable.js),
            JobSpec("Data Science", "data", R.drawable.data_science),
            JobSpec("QA", "qa", R.drawable.qa),
            JobSpec("C#", "c%23", R.drawable.c_sharp)
        )

        emit(jobList)
    }
}