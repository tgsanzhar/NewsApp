package com.example.newsfinalapp.Fragments.Settings

sealed interface SettingsEvent {
    data object toHome : SettingsEvent
    data object toNewest : SettingsEvent
    data object onProfileClick : SettingsEvent
}