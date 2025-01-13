package com.codereview.feature_vacansies

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.codereview.feature_vacansies.data.Vacancy
import com.codereview.feature_vacansies.data.VacancyRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class VacanciesViewModel @Inject constructor(private val repo: VacancyRepository) : ViewModel() {
    var result: List<Vacancy>  by mutableStateOf(listOf())
    init{ result = repo.vacancies() }
}