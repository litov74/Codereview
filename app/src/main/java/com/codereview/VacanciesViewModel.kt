package com.codereview

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.components.SingletonComponent
import javax.inject.Inject

@HiltViewModel
class VacanciesViewModel @Inject constructor(private val repo: DataRepository) : ViewModel() {
    var result: List<Vacancy>  by mutableStateOf(listOf())
    init{ result = repo.vacancies() }
}

interface DataRepository {
    fun vacancies(): List<Vacancy>
}

class DataRepoImpl@Inject constructor() : DataRepository {
    override fun vacancies() = getVacancies()
}

@InstallIn(SingletonComponent::class)
@Module
interface ProfileModule {
    @Binds
    fun getProfileSource(repo: DataRepoImpl): DataRepository
}





