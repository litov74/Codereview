package com.codereview.network

import kotlinx.serialization.SerialName

data class VacancyNet(
    @SerialName("id") val id: Int,
    @SerialName("active") val active: Boolean,
    @SerialName("company_name") val companyName: String,
    @SerialName("salary") val salary: String,
    @SerialName("speciality") val speciality: String,
    @SerialName("remote") val remote: Boolean,
    @SerialName("url") val url: String,
    @SerialName("description") val description: String,
    @SerialName("title") val title: String,
    @SerialName("external_id") val externalId: Int,
    @SerialName("location") val location: String,
    @SerialName("internship") val internship: Boolean
)
