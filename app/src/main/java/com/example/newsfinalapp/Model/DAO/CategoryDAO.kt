package com.example.newsfinalapp.Model.DAO

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.newsfinalapp.Model.Entity.Category

@Dao
interface CategoryDAO {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(news: Category)

    @Delete
    suspend fun delete(news: Category)

    @Query("SELECT * FROM category_table")
    suspend fun getAllCategories(): List<Category>
}