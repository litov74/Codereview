package com.codereview.homepage

import com.codereview.R

class JobsRepository {
    fun getJobsList() = listOf(
        JobSpec("Python", R.drawable.python),
        JobSpec("Java", R.drawable.java),
        JobSpec("JavaScript", R.drawable.js),
        JobSpec("Data Science", R.drawable.data_science),
        JobSpec("QA", R.drawable.qa),
        JobSpec("C#", R.drawable.c_sharp)
    )
}