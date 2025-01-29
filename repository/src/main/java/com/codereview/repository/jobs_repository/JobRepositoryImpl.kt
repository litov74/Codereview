package com.codereview.repository.jobs_repository

import com.codereview.core.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class JobRepositoryImpl @Inject constructor(): JobRepository {

    override fun getJobList(): Flow<List<JobSpec>> = flow {
        val jobList = listOf(
            JobSpec("Python", R.drawable.python),
            JobSpec("Java", R.drawable.java),
            JobSpec("JavaScript", R.drawable.js),
            JobSpec("Data Science", R.drawable.data_science),
            JobSpec("QA", R.drawable.qa),
            JobSpec("C#", R.drawable.c_sharp)
        )

        emit(jobList)
    }
}