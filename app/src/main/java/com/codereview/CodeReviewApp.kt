package com.codereview

import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.codereview.navigation.CodeReviewNavHost

@Composable
fun CodeReviewApp() {
    val navHostController = rememberNavController()
    CodeReviewNavHost(navHostController)
}

