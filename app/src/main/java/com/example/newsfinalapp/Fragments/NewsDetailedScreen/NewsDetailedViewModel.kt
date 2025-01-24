package com.example.newsfinalapp.Fragments.NewsDetailedScreen

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.newsfinalapp.Fragments.BaseScreen.BaseEvent
import com.example.newsfinalapp.Fragments.BaseScreen.BaseState
import com.example.newsfinalapp.Fragments.BaseScreen.ColumnUIState
import com.example.newsfinalapp.Fragments.BaseScreen.RowUIState
import com.example.newsfinalapp.data.repository.NewsRepository
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlin.math.log

class NewsDetailedViewModel(
    private val repository: NewsRepository
): ViewModel() {

    var state = mutableStateOf(
        NewsDetailedState(
                id = -1,
                image = "",
                title = "",
                author = "",
                category = "",
                readTime = "",
            )
        )

    fun dispatch(event: NewsDetailedEvent, type: String, id: Int) {
        when(event){

            NewsDetailedEvent.getNews -> {
                viewModelScope.launch {
                    val result = repository.getNewsById(type, id)
                    Log.d("TAG", type)
                    if (type == "column"){
                        state.value = state.value.copy(
                            id = result.id ?: 0,
                            image = result.image ?: "",
                            title = result.title ?: "",
                            author = result.author ?: "",
                            category = result.category ?: "",
                            readTime = result.readTime ?: "",
                        )
                    }
                }

            }
        }

    }
}