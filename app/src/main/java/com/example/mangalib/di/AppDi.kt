package com.example.mangalib.di

import com.example.mangalib.presentation.ui.activity.ui.home.HomeViewModel
import com.example.mangalib.presentation.ui.fragment.topmanga.TopMangaViewModel
import com.example.mangalib.presentation.ui.fragment.manga.AllMangaViewModel
import com.example.mangalib.presentation.ui.fragment.open.OpenViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val appModule = module {
    viewModel {
        TopMangaViewModel(get())
    }
    viewModel {
        AllMangaViewModel(get(), get())

    }
    viewModel {
        HomeViewModel(get())

    }
    viewModel {
        OpenViewModel(get())
    }
}