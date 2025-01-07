package com.codereview

import android.app.Application
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.codereview.homepage.JobsRepository
import com.codereview.navigation.CodeReviewNavHost


class CodeReviewApplication : Application() {
    val jobsRepository: JobsRepository by lazy { JobsRepository() }
}

@Composable
fun CodeReviewApp() {
    val navHostController = rememberNavController()
    CodeReviewNavHost(navHostController)
}

