package com.example.newsfinalapp.Model.Entity

import androidx.room.*

@Entity(tableName = "news_row_table")
data class NewsRowRoomDTO(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "subtitle") val subtitle: String,

)


@Entity(tableName = "news_column_table")
data class NewsColumnRoomDTO(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "image") val image: String,
    @ColumnInfo(name = "title") val title: String,
    @ColumnInfo(name = "category") val category: String,
    @ColumnInfo(name = "author") val author: String,
    @ColumnInfo(name = "during") val during: String,

)