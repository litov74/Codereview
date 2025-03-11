package com.codereview.repository.vacancy_repository

data class Vacancy(
    val id: String,
    val active: Boolean,
    val companyName: String,
    val salary: String,
    val speciality: String,
    val remote: Boolean,
    val url: String,
    val description: String,
    val title: String,
    val externalId: String,
    val location: String,
    val internship: Boolean
)
