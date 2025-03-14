package com.codereview.feature_jobs

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codereview.feature_jobs.state.HomeState
import com.codereview.feature_jobs.state.HomeUiState
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

    private val _state = MutableStateFlow<HomeState>(HomeState.Loading)
    val state: StateFlow<HomeState> = _state

    private val _uiState = MutableStateFlow(HomeUiState())
    val uiState: StateFlow<HomeUiState> = _uiState

    init {
        viewModelScope.launch {
            _state.value = HomeState.Loading
            repository.getJobList()
                .catch {
                    _state.emit(HomeState.Error(it.message))
            }
                .collect { result ->
                    _state.emit(HomeState.Ready(result))
                }
        }
    }
}