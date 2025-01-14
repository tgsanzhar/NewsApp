package com.example.newsfinalapp.Fragments.StartScreen

sealed interface StartEvent{
    data object onClick : StartEvent
}