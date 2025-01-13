package com.codereview.homepage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class HomepageViewModel(repository: JobsRepository) : ViewModel() {
    val listOfJobs = repository.getJobsList()
}

class HomepageViewModelFactory(private val repository: JobsRepository) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        @Suppress("UNCHECKED_CAST")
        if (modelClass.isAssignableFrom(HomepageViewModel::class.java)) {
            return HomepageViewModel(repository) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}