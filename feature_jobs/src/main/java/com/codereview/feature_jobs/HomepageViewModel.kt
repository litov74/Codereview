package com.codereview.feature_jobs

import androidx.lifecycle.ViewModel
import com.codereview.feature_jobs.data.JobsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(
    private val repository: JobsRepository
) : ViewModel() {

    val listOfJobs = repository.getJobsList()

}