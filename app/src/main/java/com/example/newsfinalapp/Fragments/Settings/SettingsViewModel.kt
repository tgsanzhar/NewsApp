package com.example.newsfinalapp.Fragments.Settings

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.newsfinalapp.R

class SettingsViewModel : ViewModel() {

    fun dispatch(event: SettingsEvent, navController: NavController, context: Context) {
        when (event) {
            SettingsEvent.onProfileClick -> {

            }

            SettingsEvent.toHome -> {
                navController.navigate(
                    R.id.action_settingsFragment_to_baseFragment,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.navigation, true)
                        .build()
                )
            }
            SettingsEvent.toNewest -> {
                navController.navigate(
                    R.id.action_settingsFragment_to_newestFragment,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.navigation, true)
                        .build()
                )
            }
        }
    }
}