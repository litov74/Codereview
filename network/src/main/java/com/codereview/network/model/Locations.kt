package com.codereview.network

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Locations (

  @SerialName("total_count" ) var totalCount : Int?              = null,
  @SerialName("data"        ) var data       : ArrayList<String?> = arrayListOf()

)