package com.example.mangalib.domain.model.usecase

import com.example.mangalib.domain.model.repository.MangaRepository

class GetAllMangaIdUseCase(private val repository: MangaRepository) {
    fun getAllMangaId(id:Int)=repository.getAllMangaId(id)
}