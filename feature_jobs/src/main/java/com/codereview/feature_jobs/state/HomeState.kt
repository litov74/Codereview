package com.codereview.feature_jobs.state

import com.codereview.repository.jobs_repository.JobSpec

sealed class HomeState {
    data object Loading : HomeState()
    data class Error(val message: String?) : HomeState()
    data class Ready(val data: List<JobSpec>) : HomeState()
}