package com.example.newsfinalapp.Model.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsfinalapp.Model.Entity.NewsColumnRoomDTO
import com.example.newsfinalapp.Model.Entity.NewsRowRoomDTO

@Dao
interface NewsDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertRowNews(news: List<NewsRowRoomDTO>)

    @Query("DELETE FROM news_row_table")
    suspend fun deleteRowNews()

    @Query("SELECT * FROM news_row_table")
    suspend fun getAllNewsRow(): List<NewsRowRoomDTO>



    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertColumnNews(news: List<NewsColumnRoomDTO>)

    @Query("DELETE FROM news_column_table")
    suspend fun deleteColumnNews()

    @Query("SELECT * FROM news_column_table")
    suspend fun getAllNewsColumn(): List<NewsColumnRoomDTO>
}