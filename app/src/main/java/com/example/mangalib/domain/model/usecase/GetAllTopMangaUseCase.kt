package com.example.mangalib.domain.model.usecase

import com.example.mangalib.domain.model.repository.MangaRepository

class GetAllTopMangaUseCase(val repository: MangaRepository) {
    fun getAllMangaTop() = repository.getAllTopManga()


}