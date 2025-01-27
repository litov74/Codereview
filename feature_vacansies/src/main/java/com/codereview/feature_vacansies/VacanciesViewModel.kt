package com.codereview.feature_vacansies

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codereview.repository.vacancy_repository.Vacancy
import com.codereview.repository.vacancy_repository.VacancyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VacanciesViewModel @Inject constructor(
    private val repository: VacancyRepository
) : ViewModel() {

    val _vacancyList: MutableStateFlow<List<Vacancy>?> = MutableStateFlow(null)
    val vacancyList: StateFlow<List<Vacancy>?> get() = _vacancyList

    init {
        viewModelScope.launch {
            repository.getVacancyList(100)
                .catch {
                    Log.d(this.javaClass.simpleName, "UnableToFetchVacancies")
                }
                .collect { result ->
                    _vacancyList.emit(result)
                }
        }
    }
}