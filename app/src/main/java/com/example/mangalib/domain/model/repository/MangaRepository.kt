package com.example.mangalib.domain.model.repository

import com.example.mangalib.domain.model.ResultModel
import com.example.mangalib.domain.model.utils.Resourse
import kotlinx.coroutines.flow.Flow

interface MangaRepository {
    fun getAllTopManga(): Flow<Resourse<List<ResultModel>>>

    fun getAllManga(): Flow<Resourse<List<ResultModel>>>

    fun getAllMangaSearch(search: String): Flow<Resourse<List<ResultModel>>>

    fun getAllMangaId(id: Int): Flow<Resourse<List<ResultModel>>>
}