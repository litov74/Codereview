package com.codereview.repository.jobs_repository

import com.codereview.core.R

enum class JobSpec(val jobTitle: String, val specialities: String, val logoId: Int) {
    PYTHON(jobTitle = "Python", specialities = "python", R.drawable.python),
    JAVA(jobTitle = "Java", specialities = "java", R.drawable.java),
    JAVASCRIPT(jobTitle = "JavaScript", specialities = "javascript", R.drawable.js),
    DATASCIENCE(jobTitle = "Data Science", specialities = "data", R.drawable.data_science),
    QA(jobTitle = "QA", specialities = "qa", R.drawable.qa),
    CSHARP(jobTitle = "C#", specialities = "c%23", R.drawable.c_sharp)
}
