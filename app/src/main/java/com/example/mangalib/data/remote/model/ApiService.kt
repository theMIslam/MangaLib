package com.example.mangalib.data.remote.model

import com.example.mangalib.domain.model.Paging
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiService {
    @GET("v1/top-manga")
    suspend fun getAllTopManga(): List<ResultDto>

    @GET("v1/manga/")
    suspend fun getAllManga(

    ): List<ResultDto>

    @GET("v1/manga/{id}")
    suspend fun getAllMangaId(
        @Path("id") id: Int
    ): List<ResultDto>

    @GET("v1/manga/")
    suspend fun getAllMangaSearch(
        @Query("search") search: String
    ): List<ResultDto>

    @GET("v1/manga/")
    suspend fun Paging3(
        @Query("limit") limit: Int,
        @Query("offset") offset: Int
    ): Paging

}