package com.example.mangalib.di

import com.example.mangalib.data.repository.MangaRepositoryImpl
import com.example.mangalib.domain.model.repository.MangaRepository
import org.koin.dsl.module

val dataModule = module {

    single<MangaRepository> {
        MangaRepositoryImpl(api = get())
    }
}