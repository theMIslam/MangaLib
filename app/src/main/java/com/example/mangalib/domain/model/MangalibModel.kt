package com.example.mangalib.domain.model

data class MangalibModel(
    val count: Int,
    val next: String,
    val previous: Any,
    val results: List<ResultModel>
)

data class ResultModel(
    val chapters_quantity: Int,
    val created_at: String,
    val en_name: String,
    val genre: List<Int>,
    val id: Int,
    val image: String,
    val issue_year: Int,
    val likes: Int,
    val rating: Double,
    val ru_name: String,
    val dir: String,
    val type: String,
    val updated_at: String,
    val description: String
)