package com.example.mangalib.domain.usecase

import com.example.mangalib.domain.repository.MangaRepository

class GetMangaSearchUseCase(val repository: MangaRepository) {
    fun getMangaSearch(search: String) = repository.getAllMangaSearch(search)

}