package com.example.mangalib.presentation.ui.activity.ui.home

import com.example.mangalib.domain.model.ResultModel
import com.example.mangalib.domain.usecase.GetMangaSearchUseCase
import com.example.mangalib.domain.utils.UiState
import com.example.mangalib.presentation.ui.base.BaseViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow

class HomeViewModel(
    private val getMangaSearchUseCase: GetMangaSearchUseCase
) : BaseViewModel() {

    private val _getAllMangaSearch = MutableStateFlow<UiState<List<ResultModel>>>(UiState.Empty())
    val getMangaSearch = _getAllMangaSearch.asStateFlow()

    /* fun getMangaSearch(search:String) {
         getMangaSearchUseCase.getMangaSearch(search).onEach {   result->
             when(result){
                 is Resourse.Success ->{
                     _getAllMangaSearch.value= AllMangaSearch(data = result.data)

                 }
                 is Resourse.Error ->{
                     _getAllMangaSearch.value = AllMangaSearch(error = result.message ?: "error")

                 }
                 is Resourse.Loading ->{
                     _getAllMangaSearch.value = AllMangaSearch(isLoading = true)

                 }
             }
         }.launchIn(viewModelScope)*/
    /*fun getMangaSearch(search:String) {
        getMangaSearchUseCase.getMangaSearch(search).onEach { result->
            when(result){
                is Resourse.Success ->{
                    _getAllMangaSearch.value=UiState.Success(result.data!!)

                }
                is Resourse.Error ->{
                    _getAllMangaSearch.value = UiState.Error(result.message!!)

                }
                is Resourse.Loading ->{
                    _getAllMangaSearch.value = UiState.Loading()

                }
            }
        }.launchIn(viewModelScope)*/


}



