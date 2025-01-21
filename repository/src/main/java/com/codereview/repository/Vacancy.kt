package com.codereview.repository

data class Vacancy(
    val id: Int,
    val active: Boolean,
    val companyName: String,
    val salary: String,
    val speciality: String,
    val remote: Boolean,
    val url: String,
    val description: String,
    val title: String,
    val externalId: Int,
    val location: String,
    val internship: Boolean
)
