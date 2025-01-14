package com.example.newsfinalapp.Model

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.newsfinalapp.Model.DAO.CategoryDAO
import com.example.newsfinalapp.Model.DAO.NewsDAO
import com.example.newsfinalapp.Model.Entity.Category
import com.example.newsfinalapp.Model.Entity.NewsColumnRoomDTO
import com.example.newsfinalapp.Model.Entity.NewsRowRoomDTO

@Database(entities = [NewsColumnRoomDTO::class, NewsRowRoomDTO::class, Category::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun categoryDAO(): CategoryDAO
    abstract fun newsDAO(): NewsDAO
}