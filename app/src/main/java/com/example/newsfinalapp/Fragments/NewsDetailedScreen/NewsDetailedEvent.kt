package com.example.newsfinalapp.Fragments.NewsDetailedScreen

sealed interface NewsDetailedEvent {
    object getNews: NewsDetailedEvent
}