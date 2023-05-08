package com.example.mangalib.domain.model.usecase

import com.example.mangalib.domain.model.repository.MangaRepository

class GetAllMangaUseCase(private val repository: MangaRepository) {
    fun getAllManga() = repository.getAllManga()

}