package com.example.mangalib.domain.model.usecase

import com.example.mangalib.domain.model.repository.MangaRepository

class GetMangaSearchUseCase(val repository: MangaRepository) {
    fun getMangaSearch(search: String) = repository.getAllMangaSearch(search)

}