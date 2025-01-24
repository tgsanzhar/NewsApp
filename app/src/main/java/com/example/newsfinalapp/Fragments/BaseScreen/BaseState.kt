package com.example.newsfinalapp.Fragments.BaseScreen


data class BaseState(
    val searchText: String,
    var isFocused: Boolean,
    val rowData: RowUIState,
    val columnData: ColumnUIState
)

data class RowNewsItem(
    val id: Int,
    val imageSrc: String,
    val title: String,
    val subTitle: String
)

data class ColumnNewsItem(
    val id: Int,
    val category: String,
    val author: String,
    val readTime: String,
    val image: String,
    val title: String
)

interface ColumnUIState {

    val news: List<ColumnNewsItem>

    object OnLoading : ColumnUIState {
        override val news: List<ColumnNewsItem> = emptyList<ColumnNewsItem>()
    }

    data class OnGetNews(
        override val news: List<ColumnNewsItem>
    ) : ColumnUIState
}


interface RowUIState {

    val news: List<RowNewsItem>

    object OnLoading : RowUIState {
        override val news: List<RowNewsItem> = emptyList<RowNewsItem>()
    }

    data class OnGetNews(
        override val news: List<RowNewsItem>
    ) : RowUIState
}

