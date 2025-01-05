package com.codereview

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.codereview.ui.theme.CodeReviewTheme
import com.codereview.ui.theme.VacancyList

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CodeReviewTheme {
                //HomePage()
                val listVac = getVacancies()
                VacancyList(listVac)
            }
        }
    }
}
