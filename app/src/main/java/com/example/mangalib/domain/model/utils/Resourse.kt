package com.example.mangalib.domain.model.utils


sealed class Resourse<T>(
    val data: T? = null,
    val message: String? = null
) {
    class Loading<T> : Resourse<T>()
    class Success<T>(data: T) : Resourse<T>(data = data)
    class Error<T>(message: String, data: T? = null) : Resourse<T>(message = message, data = data)

}