package com.example.mangalib.presentation.ui.fragment.topmanga

import com.example.mangalib.domain.model.ResultModel
import com.example.mangalib.domain.usecase.GetAllTopMangaUseCase
import com.example.mangalib.domain.utils.UiState
import com.example.mangalib.presentation.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class TopMangaViewModel(
    private val getAllTopMangaUseCase: GetAllTopMangaUseCase
) : BaseViewModel() {

    private val _getAllTopManga = MutableStateFlow<UiState<List<ResultModel>>>(UiState.Empty())
    val getTopAllManga = _getAllTopManga.asStateFlow()


    fun getAllTopManga() {
        getAllTopMangaUseCase.getAllMangaTop().collectFlow(_getAllTopManga)
    }
}