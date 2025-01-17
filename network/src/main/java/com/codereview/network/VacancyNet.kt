package com.codereview.network

import kotlinx.serialization.SerialName

data class VacancyNet(
    val id: Int,
    val active: Boolean,
    @SerialName("company_name") val companyName: String,
    val salary: String,
    val speciality: String,
    val remote: Boolean,
    val url: String,
    val description: String,
    val title: String,
    @SerialName("external_id") val externalId: Int,
    val location: String,
    val internship: Boolean
)
