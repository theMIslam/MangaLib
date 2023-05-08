package com.example.mangalib.domain.usecase

import com.example.mangalib.domain.repository.MangaRepository

class GetAllTopMangaUseCase(val repository: MangaRepository) {
    fun getAllMangaTop() = repository.getAllTopManga()


}