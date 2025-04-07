package com.codereview.navigation

interface Route {
    val route: String
}

object HomePageDestination : Route {
    override val route: String = "home_page"
}

object VacanciesDestination : Route {
    override val route: String = "vacancies"
}

object VacancyDestination: Route {
    override val route: String = "vacancy"
}