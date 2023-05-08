package com.example.mangalib.presentation.ui.fragment.manga

import androidx.lifecycle.viewModelScope
import com.example.mangalib.domain.model.ResultModel
import com.example.mangalib.domain.usecase.GetAllMangaUseCase
import com.example.mangalib.domain.usecase.GetMangaSearchUseCase
import com.example.mangalib.domain.utils.Resourse
import com.example.mangalib.domain.utils.UiState
import com.example.mangalib.presentation.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class AllMangaViewModel(
    private val getAllMangaUseCase: GetAllMangaUseCase,
    private val getMangaSearchUseCase: GetMangaSearchUseCase


) : BaseViewModel() {
    private val _getAllMangaSearch = MutableStateFlow<UiState<List<ResultModel>>>(UiState.Empty())
    val getMangaSearch = _getAllMangaSearch.asStateFlow()

    private val _getAllManga = MutableStateFlow<UiState<List<ResultModel>>>(UiState.Empty())
    val getAllManga = _getAllManga.asStateFlow()

    fun getAllManga() {
        getAllMangaUseCase.getAllManga().onEach { result ->
            when (result) {
                is Resourse.Success -> {
                    if (result !== null)
                        _getAllManga.value = UiState.Success(result.data!!)

                }

                is Resourse.Error -> {
                    _getAllManga.value = UiState.Error(result.message!!)

                }

                is Resourse.Loading -> {
                    _getAllManga.value = UiState.Loading()

                }
            }
        }.launchIn(viewModelScope)

    }

    fun getMangaSearch(search: String) {
        getMangaSearchUseCase.getMangaSearch(search).onEach { result ->
            when (result) {
                is Resourse.Success -> {
                    _getAllMangaSearch.value = UiState.Success(result.data!!)

                }

                is Resourse.Error -> {
                    _getAllMangaSearch.value = UiState.Error(result.message!!)

                }

                is Resourse.Loading -> {
                    _getAllMangaSearch.value = UiState.Loading()

                }
            }
        }.launchIn(viewModelScope)
    }

}