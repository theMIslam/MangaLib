package com.example.mangalib.data.repository

import com.example.mangalib.data.base.BaseRepository
import com.example.mangalib.data.mapper.toManga
import com.example.mangalib.data.remote.model.ApiService
import com.example.mangalib.domain.model.ResultModel
import com.example.mangalib.domain.model.repository.MangaRepository
import com.example.mangalib.domain.model.utils.Resourse
import kotlinx.coroutines.flow.Flow

class MangaRepositoryImpl(val api: ApiService) : MangaRepository, BaseRepository() {
    override fun getAllTopManga(): Flow<Resourse<List<ResultModel>>> = doReguest {
        api.getAllTopManga().map { it.toManga() }
    }

    override fun getAllManga(): Flow<Resourse<List<ResultModel>>> = doReguest {
        api.getAllManga().map { it.toManga() }

    }

    override fun getAllMangaSearch(search: String): Flow<Resourse<List<ResultModel>>> = doReguest {
        api.getAllMangaSearch(search).map { it.toManga() }
    }

    override fun getAllMangaId(id: Int): Flow<Resourse<List<ResultModel>>> = doReguest {
        api.getAllMangaId(id).map { it.toManga() }
    }

}