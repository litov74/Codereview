package com.codereview.feature_vacansies

import android.content.Context
import android.content.Intent
import android.net.Uri
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codereview.repository.vacancy_repository.Vacancy
import com.codereview.repository.vacancy_repository.VacancyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class VacanciesViewModel @Inject constructor(
    private val repo: VacancyRepository,
    @ApplicationContext private val context: Context
) : ViewModel() {

    private val _uiState = MutableStateFlow(VacanciesUiState(isLoading = true))
    val uiState: StateFlow<VacanciesUiState> = _uiState.asStateFlow()

    fun getVacancies(
        specialities: String,
    ) {
        viewModelScope.launch {
            repo.getVacancyList(
                specialities = specialities
            ).collect { vacancies ->
                Log.d("VacanciesViewModel", "getVacancies: $vacancies")
                _uiState.update { currentState ->
                    currentState.copy(
                        isLoading = false,
                        vacancies = vacancies
                    )
                }
            }
        }
    }

    fun onVacancyClick(vacancyUrl: String) {
        val intent = Intent(Intent.ACTION_VIEW)
        intent.setData(Uri.parse(vacancyUrl))
            .addCategory(Intent.CATEGORY_DEFAULT)
            .addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY)
            .addFlags(Intent.FLAG_ACTIVITY_EXCLUDE_FROM_RECENTS)
        context.startActivity(intent)
    }

}

data class VacanciesUiState(
    val isLoading: Boolean = false,
    val vacancies: List<Vacancy> = emptyList()
)