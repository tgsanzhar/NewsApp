package com.example.newsfinalapp.Model.Entity

import androidx.room.*

@Entity(tableName = "category_table")
data class Category(
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name") val name: String,
    @ColumnInfo(name = "articleCount") val articleCount: Int,

)