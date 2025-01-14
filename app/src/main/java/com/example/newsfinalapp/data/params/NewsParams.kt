package com.example.newsfinalapp.data.params

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsParams(

    @SerialName("id")
    val id: Int? = null,
)