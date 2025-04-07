package com.codereview.network.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class VacancyList(
    @SerialName("total_count" ) var totalCount : Int?            = null,
    @SerialName("data"        ) var data       : ArrayList<VacancyNet> = arrayListOf()
)

@Serializable
data class VacancyNet(
    @SerialName("company_name"     ) var companyName     : String?  = null,
    @SerialName("salary"           ) var salary          : String?  = null,
    @SerialName("speciality"       ) var speciality      : String?  = null,
    @SerialName("remote"           ) var remote          : Boolean? = null,
    @SerialName("url"              ) var url             : String?  = null,
    @SerialName("description"      ) var description     : String?  = null,
    @SerialName("title"            ) var title           : String?  = null,
    @SerialName("active"           ) var active          : Boolean? = null,
    @SerialName("id"               ) var id              : Int?     = null,
    @SerialName("external_id"      ) var externalId      : String?  = null,
    @SerialName("location"         ) var location        : String?  = null,
    @SerialName("internship"       ) var internship      : Boolean? = null,
    @SerialName("date_publication" ) var datePublication : String?  = null
)