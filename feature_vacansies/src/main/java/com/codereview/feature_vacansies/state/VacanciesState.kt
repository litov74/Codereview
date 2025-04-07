package com.codereview.feature_vacansies.state

import com.codereview.repository.vacancy_repository.Vacancy

sealed class VacanciesState {
    data object Loading : VacanciesState()
    data class Ready(val data: List<Vacancy>) : VacanciesState()
    data class Error(val message: String) : VacanciesState()
}