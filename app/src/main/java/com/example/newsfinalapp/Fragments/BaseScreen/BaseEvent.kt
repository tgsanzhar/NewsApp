package com.example.newsfinalapp.Fragments.BaseScreen

sealed interface BaseEvent{
    data object OnGetNews : BaseEvent
    data object toNewest : BaseEvent
    data object toSettings : BaseEvent
    data class onValueChanged(val value: String) : BaseEvent
}