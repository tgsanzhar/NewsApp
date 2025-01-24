package com.example.newsfinalapp.data.repository

import com.example.newsfinalapp.Model.DAO.NewsDAO
import com.example.newsfinalapp.Model.Entity.NewsColumnRoomDTO
import com.example.newsfinalapp.Model.Entity.NewsRowRoomDTO
import com.example.newsfinalapp.data.api.NewsApi
import com.example.newsfinalapp.data.entity.ItemDTO
import com.example.newsfinalapp.data.entity.NewsDTO
import com.example.newsfinalapp.data.entity.NewsType
import com.example.newsfinalapp.data.params.NewsParams
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.flow
import java.util.Locale

class NewsRepository(
    private val newsApi: NewsApi,
    private val newsDAO: NewsDAO
) {

    suspend fun getNews(newsType: NewsType): Flow<NewsDTO> {
        return flow {
            val list = when(newsType){
                NewsType.ROW -> {
                    newsDAO.getAllNewsRow().map { ItemDTO (
                        id = it.id,
                        image = it.image,
                        title = it.title,
                        subTitle = it.subtitle
                    ) }


                }
                NewsType.COLUMN -> {
                    newsDAO.getAllNewsColumn().map { ItemDTO (
                        id = it.id,
                        image = it.image,
                        title = it.title,
                        category = it.category,
                        readTime = it.during,
                        author = it.author
                    ) }


                }
            }
            emit(NewsDTO(list))
        }
            .flatMapConcat { roomDTO ->
                flow {
                    emit(roomDTO)

                    val response = newsApi.getNews(type = newsType.name.toLowerCase(Locale.getDefault()))

                    response.onSuccess {
                        when(newsType){
                            NewsType.ROW -> {
                                newsDAO.deleteRowNews()
                                newsDAO.insertRowNews(
                                    news = it.itemDTOS.map {
                                        NewsRowRoomDTO(
                                            id = it.id,
                                            image = it.image,
                                            title = it.title,
                                            subtitle = it.subTitle.orEmpty()
                                        )
                                    }
                                )
                            }
                            NewsType.COLUMN -> {
                                newsDAO.deleteColumnNews()
                                newsDAO.insertColumnNews(
                                    news = it.itemDTOS.map {
                                        NewsColumnRoomDTO(
                                            id = it.id,
                                            image = it.image,
                                            title = it.title,
                                            category = it.category.orEmpty(),
                                            author = it.author.orEmpty(),
                                            during = it.readTime.orEmpty()
                                        )
                                    }
                                )

                            }

                        }
                        emit(it)
                    }

                }
            }
    }

    suspend fun getNewsById(
        type: String,
        id: Int
    ):ItemDTO = newsApi.getNewsById(
        type = type,
        id = id
    )

    suspend fun addNews(params: NewsParams) = newsApi.addNews(params)

}