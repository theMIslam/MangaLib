package com.example.mangalib.data.mapper

import com.example.mangalib.data.remote.model.MangalibDto
import com.example.mangalib.data.remote.model.ResultDto
import com.example.mangalib.domain.model.MangalibModel
import com.example.mangalib.domain.model.ResultModel

fun ResultModel.toMangas() = ResultDto(
    chapters_quantity,
    created_at,
    en_name,
    description,
    genre,
    id,
    image,
    issue_year,
    likes,
    rating,
    ru_name,
    dir,
    type,
    updated_at

)


fun ResultDto.toManga(): ResultModel {
    return ResultModel(
        chapters_quantity,
        created_at,
        en_name,
        genre,
        id,
        image,
        issue_year,
        likes,
        rating,
        ru_name,
        dir,
        type,
        updated_at,
        description ?: ""


    )

}

fun MangalibDto.toDataMango() = MangalibModel(
    count,
    next,
    previous,
    results.map { it.toManga() }
)

fun MangalibModel.toDomainManga() = MangalibDto(
    count,
    next,
    previous,
    results.map { it.toMangas() }
)