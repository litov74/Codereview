package com.codereview.network

import com.google.gson.annotations.SerializedName

data class VacancyNet(
    val id: Int,
    val active: Boolean,
    @SerializedName("company_name") val companyName: String, // OR use @SerialName and Kotlin serialization?
    val salary: String,
    val speciality: String,
    val remote: Boolean,
    val url: String,
    val description: String,
    val title: String,
    @SerializedName("external_id") val externalId: Int, // OR use @SerialName and Kotlin serialization?
    val location: String,
    val internship: Boolean
)
