package com.codereview.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.codereview.feature_jobs.HomePage
import com.codereview.feature_jobs.HomeScreen
import com.codereview.feature_vacancy.VacancyScreen
import com.codereview.feature_vacansies.VacanciesScreen
import com.codereview.feature_vacansies.VacancyList

private const val VACANCIES_ARG = "vacanciesArg"
private const val VACANCY_ARG = "vacancyArg"

@Composable
fun CodeReviewNavHost(navHostController: NavHostController) {
    NavHost(
        navController = navHostController,
        startDestination = HomePageDestination.route
    ) {

        composable(route = HomePageDestination.route) {
            HomeScreen(
                onNavigateToVacancies = { vacanciesArg ->
                    navHostController
                        .navigateSingleTopTo(VacanciesDestination.route + vacanciesArg)
                })
        }

        composable(route = VacanciesDestination.route + "/{$VACANCIES_ARG}") { entry ->
            val vacanciesArg = entry.arguments?.getString(VACANCIES_ARG)
            VacanciesScreen(
                vacanciesArg = vacanciesArg,
                onNavigateToVacancy = { vacancyArg ->
                    navHostController
                        .navigateSingleTopTo(VacancyDestination.route + vacancyArg)
                }
            )
        }
        composable(route = VacancyDestination.route + "/{$VACANCY_ARG}") { entry ->
            val vacancyArg = entry.arguments?.getString(VACANCY_ARG)
            VacancyScreen(
                vacancyId = vacancyArg,
                navigateUp = { navHostController.navigateUp() }
            )
        }
    }
}

fun NavHostController.navigateSingleTopTo(route: String) = this.navigate(route) {
    launchSingleTop = true
}