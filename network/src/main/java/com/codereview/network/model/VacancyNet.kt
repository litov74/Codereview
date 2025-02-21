package com.codereview.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class VacancyNet(
    @SerialName("company_name")
    val companyName: String? = null,
    @SerialName("salary")
    val salary: String? = null,
    @SerialName("speciality")
    val speciality: String? = null,
    @SerialName("remote")
    val remote: Boolean? = null,
    @SerialName("url")
    val url: String? = null,
    @SerialName("description")
    val description: String? = null,
    @SerialName("active")
    val active: Boolean? = null,
    @SerialName("id")
    val id: Int? = null,
    @SerialName("title")
    val title: String? = null,
    @SerialName("external_id")
    val externalId: Int? = null,
    @SerialName("location")
    val location: String? = null,
    @SerialName("internship")
    val internship: Boolean? = null,
    @SerialName("date_publication")
    val datePublication: String? = null,
)