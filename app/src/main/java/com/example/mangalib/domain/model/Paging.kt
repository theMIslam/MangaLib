package com.example.mangalib.domain.model

import com.example.mangalib.data.remote.model.MangalibDto

data class Paging(
    val result: List<MangalibDto>
)