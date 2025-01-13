package com.codereview.feature_jobs.data

import javax.inject.Inject
import com.codereview.core.R as coreR

class JobsRepository @Inject constructor() {
    fun getJobsList() = listOf(
        JobSpec("Python", coreR.drawable.python),
        JobSpec("Java", coreR.drawable.java),
        JobSpec("JavaScript", coreR.drawable.js),
        JobSpec("Data Science", coreR.drawable.data_science),
        JobSpec("QA", coreR.drawable.qa),
        JobSpec("C#", coreR.drawable.c_sharp)
    )
}