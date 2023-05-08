package com.example.mangalib.di

import com.example.mangalib.domain.usecase.GetAllMangaIdUseCase
import com.example.mangalib.domain.usecase.GetAllMangaUseCase
import com.example.mangalib.domain.usecase.GetAllTopMangaUseCase
import com.example.mangalib.domain.usecase.GetMangaSearchUseCase
import org.koin.dsl.module

val domainModule = module {
    factory<GetAllTopMangaUseCase> {
        GetAllTopMangaUseCase(repository = get())
    }
    factory {
        GetAllMangaUseCase(repository = get())
    }
    factory {
        GetMangaSearchUseCase(repository = get())
    }
    factory {
        GetAllMangaIdUseCase(repository = get())
    }
}