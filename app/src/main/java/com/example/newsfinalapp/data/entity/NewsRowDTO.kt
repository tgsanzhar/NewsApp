package com.example.newsfinalapp.data.entity

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class NewsDTO(
    @SerialName("items")
    val itemDTOS: List<ItemDTO>
)

@Serializable
data class ItemDTO(
    @SerialName("id")
    val id: Int,

    @SerialName("image")
    val image: String,

    @SerialName("subTitle")
    val subTitle: String? =null,

    @SerialName("category")
    val category: String? =null,

    @SerialName("author")
    val author: String? =null,

    @SerialName("readTime")
    val readTime: String? =null,

    @SerialName("title")
    val title: String
)