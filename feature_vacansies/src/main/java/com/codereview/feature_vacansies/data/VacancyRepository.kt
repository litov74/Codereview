package com.codereview.feature_vacansies.data

import javax.inject.Inject

interface VacancyRepository {
    fun vacancies(): List<Vacancy>
}

class VacancyRepoImpl@Inject constructor() : VacancyRepository {
    override fun vacancies() = getVacancies()
}