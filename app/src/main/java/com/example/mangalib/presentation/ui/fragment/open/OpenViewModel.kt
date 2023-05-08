package com.example.mangalib.presentation.ui.fragment.open

import androidx.lifecycle.viewModelScope
import com.example.mangalib.domain.model.ResultModel
import com.example.mangalib.domain.usecase.GetAllMangaIdUseCase
import com.example.mangalib.domain.utils.Resourse
import com.example.mangalib.domain.utils.UiState
import com.example.mangalib.presentation.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

class OpenViewModel(private val getAllMangaIdUseCase: GetAllMangaIdUseCase) : BaseViewModel() {

    private val _getAllMangaId = MutableStateFlow<UiState<List<ResultModel>>>(UiState.Empty())
    val getAllMangaId = _getAllMangaId.asStateFlow()

    fun getAllMangaId(id: Int) {
        getAllMangaIdUseCase.getAllMangaId(id).onEach { result ->
            when (result) {
                is Resourse.Success -> {
                    _getAllMangaId.value = UiState.Success(result.data!!)

                }

                is Resourse.Error -> {
                    _getAllMangaId.value = UiState.Error(result.message!!)

                }

                is Resourse.Loading -> {
                    _getAllMangaId.value = UiState.Loading()

                }
            }
        }.launchIn(viewModelScope)
    }
}