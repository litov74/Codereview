package com.codereview.network.model


import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VacanciesNet(
    @SerialName("total_count")
    val totalCount: Int,
    @SerialName("data")
    val `data`: List<VacancyNet>,
)