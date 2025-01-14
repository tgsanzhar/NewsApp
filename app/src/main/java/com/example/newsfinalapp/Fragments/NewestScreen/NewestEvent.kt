package com.example.newsfinalapp.Fragments.NewestScreen

sealed interface NewestEvent {
    data object toHome: NewestEvent
    data object toSettings: NewestEvent
    data class onFilterValueChanged(val string: String) : NewestEvent
}