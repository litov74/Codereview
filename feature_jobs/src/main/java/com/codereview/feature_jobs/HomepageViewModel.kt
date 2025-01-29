package com.codereview.feature_jobs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codereview.repository.jobs_repository.JobRepository
import com.codereview.repository.jobs_repository.JobSpec
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomepageViewModel @Inject constructor(
    private val repository: JobRepository
) : ViewModel() {

    private val _jobList = MutableStateFlow<List<JobSpec>>(emptyList())
    val jobList: StateFlow<List<JobSpec>> get() = _jobList

    private val _errorFlow = MutableSharedFlow<String>()
    val errorFlow: SharedFlow<String> get() = _errorFlow // Add a snackbar?

    init {
        viewModelScope.launch {
            repository.getJobList().catch {
                _errorFlow.emit("Unable to fetch job list")
            }
                .collect { result ->
                    _jobList.emit(result)
                }
        }
    }
}