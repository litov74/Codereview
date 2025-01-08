package com.codereview.di

import com.codereview.Vacancy
import com.codereview.getVacancies
import javax.inject.Inject

interface VacancyRepository {
    fun vacancies(): List<Vacancy>
}

class VacancyRepoImpl@Inject constructor() : VacancyRepository {
    override fun vacancies() = getVacancies()
}