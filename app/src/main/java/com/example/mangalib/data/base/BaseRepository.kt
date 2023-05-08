package com.example.mangalib.data.base

import com.example.mangalib.domain.model.utils.Resourse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import java.io.IOException

abstract class BaseRepository {

    protected fun <T> doReguest(reguest: suspend () -> T) = flow {
        emit(Resourse.Loading())
        try {
            val data = reguest()
            emit(Resourse.Success(data))
        } catch (ioException: IOException) {
            emit(Resourse.Error(ioException.localizedMessage ?: "hj"))
        }

    }.flowOn(Dispatchers.IO)
}