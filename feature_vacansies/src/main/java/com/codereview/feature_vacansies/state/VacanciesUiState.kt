package com.codereview.feature_vacansies.state

import com.codereview.repository.vacancy_repository.Vacancy

data class VacanciesUiState(
    val isLoading: Boolean = false,
    val errorMessage: String? = null,
    val vacancies: List<Vacancy> = emptyList()
)