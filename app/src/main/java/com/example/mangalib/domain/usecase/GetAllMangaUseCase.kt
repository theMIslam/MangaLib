package com.example.mangalib.domain.usecase

import com.example.mangalib.domain.repository.MangaRepository

class GetAllMangaUseCase(private val repository: MangaRepository) {
    fun getAllManga() = repository.getAllManga()

}