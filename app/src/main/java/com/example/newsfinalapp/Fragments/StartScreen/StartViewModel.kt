package com.example.newsfinalapp.Fragments.StartScreen

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import com.example.newsfinalapp.R
import com.example.newsfinalapp.data.params.NewsParams
import com.example.newsfinalapp.data.repository.NewsRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class StartViewModel(

) : ViewModel() {

    fun dispatch(event: StartEvent, navController: NavController, context: Context) {
        when (event) {
            StartEvent.onClick -> {
//                viewModelScope.launch(Dispatchers.IO) {
//
//                    val result = newsRepository.addNews(NewsParams(1))
//                    result.onSuccess {
//                        println(it)
//
//                    }
//                    .onFailure {
//                        println(it)
//
//                    }
//
//                }
                navController.navigate(R.id.action_start_to_base)
            }
        }
    }
}

