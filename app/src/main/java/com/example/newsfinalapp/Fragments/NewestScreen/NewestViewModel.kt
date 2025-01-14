package com.example.newsfinalapp.Fragments.NewestScreen

import android.content.Context
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.newsfinalapp.Fragments.BaseScreen.BaseEvent
import com.example.newsfinalapp.R

class NewestViewModel : ViewModel() {

    var state = mutableStateOf(
        NewestState(
            newsRow = emptyList(),
            filterChose = ""
        )
    )

    fun dispatch(event: NewestEvent, navController: NavController, context: Context) {
        when (event) {
            NewestEvent.toHome -> {
                navController.navigate(
                    R.id.action_newestFragment_to_baseFragment,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.navigation, true)
                        .build()
                )
            }
            NewestEvent.toSettings -> {
                navController.navigate(
                    R.id.action_newestFragment_to_settingsFragment,
                    null,
                    NavOptions.Builder()
                        .setPopUpTo(R.id.navigation, true)
                        .build()
                )
            }
            is NewestEvent.onFilterValueChanged -> {

            }
        }
    }
}