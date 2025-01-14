package com.example.newsfinalapp.Fragments.NewestScreen

import com.example.newsfinalapp.Model.Entity.NewsRowRoomDTO


data class NewestState(
    val filterChose: String,
    val newsRow: List<NewsRowRoomDTO>
)