package com.example.newsfinalapp.Fragments.BaseScreen

import android.content.Context
import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.NavController
import androidx.navigation.NavOptions
import com.example.newsfinalapp.Model.AppDatabase
import com.example.newsfinalapp.Model.DAO.NewsDAO
import com.example.newsfinalapp.R
import com.example.newsfinalapp.data.api.NewsApi
import com.example.newsfinalapp.data.entity.NewsType
import com.example.newsfinalapp.data.repository.NewsRepository
import kotlinx.coroutines.launch
import org.koin.core.module.dsl.viewModel
import org.koin.dsl.module



class BaseViewModel(
    private val repository: NewsRepository
): ViewModel() {

    var state = mutableStateOf(
        BaseState(
            searchText = "",
            isFocused = false,
            rowData = RowUIState.OnLoading,
            columnData = ColumnUIState.OnLoading,
        )
    )

    fun dispatch(event: BaseEvent) {
        when (event) {

            BaseEvent.toNewest -> {
//                navController.navigate(
//                    R.id.action_baseFragment_to_newestFragment,
//                    null,
//                    NavOptions.Builder()
//                        .setPopUpTo(R.id.navigation, true)
//                        .build()
//                )
            }

            BaseEvent.toSettings -> {
//                navController.navigate(
//                    R.id.action_baseFragment_to_settingsFragment,
//                    null,
//                    NavOptions.Builder()
//                        .setPopUpTo(R.id.navigation, true)
//                        .build()
//                )
            }

            is BaseEvent.onValueChanged -> {
                state.value = state.value.copy(searchText = event.value)
            }

            BaseEvent.OnGetNews -> {
                viewModelScope.launch {
                    repository.getNews(NewsType.ROW).collect {
                        state.value =
                            state.value.copy(rowData = RowUIState.OnGetNews(it.itemDTOS.map {
                                RowNewsItem(
                                    id = it.id,
                                    title = it.title,
                                    subTitle = it.subTitle.orEmpty(),
                                    imageSrc = it.image
                                )
                            }))
                    }


                    repository.getNews(NewsType.COLUMN).collect {
                        state.value =
                            state.value.copy(
                                columnData = ColumnUIState.OnGetNews(
                                    it.itemDTOS.map {
                                        ColumnNewsItem(
                                            id = it.id,
                                            title = it.title,
                                            category = it.category.orEmpty(),
                                            author = it.author.orEmpty(),
                                            readTime = it.readTime.orEmpty(),
                                            image = it.image,
                                        )
                                    }
                                )
                            )

                    }

                }

            }
        }
    }
}
