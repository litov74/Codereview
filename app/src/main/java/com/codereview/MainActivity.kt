package com.codereview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.hilt.navigation.compose.hiltViewModel
import com.codereview.ui.theme.CodeReviewTheme
import com.codereview.ui.theme.VacancyList
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeReviewTheme {
                val viewModel: VacanciesViewModel = hiltViewModel()
                val listVac = viewModel.result
                VacancyList(vacancies = listVac, vacanciesArg = null)
            }
        }
    }
}
