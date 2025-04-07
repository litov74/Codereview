package com.example.filters


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.codereview.repository.jobs_repository.JobSpec
import com.codereview.repository.locations_repository.LocationRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class FiltersViewModel @Inject constructor(private val repository: LocationRepository) : ViewModel() {
    private val _cityState = MutableStateFlow<ArrayList<String?>>(arrayListOf())
    val cityState: StateFlow<ArrayList<String?>> = _cityState

    private val _specState = MutableStateFlow<ArrayList<String?>>(arrayListOf())
    val specState: StateFlow<ArrayList<String?>> = _specState

    fun getLocations() = viewModelScope.launch {
        repository.getLocations()
            .flowOn(Dispatchers.IO)
            .catch { e -> Log.d("ErrorCity", e.message.toString()) }
            .collect { value ->
                _cityState.emit(value)
            }

        repository.getSpecialities()
            .flowOn(Dispatchers.IO)
            .catch { e -> Log.d("ErrorSpec", e.message.toString()) }
            .collect { value ->
                _specState.emit(value)
            }
    }

    init{getLocations()}
}
