package com.example.mvvmexample.data.repository

import androidx.lifecycle.liveData
import com.example.mvvmexample.data.network.FilmsApi
import com.example.mvvmexample.data.network.Resource
import kotlinx.coroutines.Dispatchers
import java.lang.Exception

class FilmsRepository(private val api: FilmsApi) {

    fun getFilms() = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(api.getFilms()))
        } catch (e: Exception) {
            emit(Resource.error(null, e.localizedMessage ?: "unknown error"))
        }
    }

    fun getFilmById(id: String) = liveData(Dispatchers.IO) {
        emit(Resource.loading(null))
        try {
            emit(Resource.success(api.getFilmById(id)))
        } catch (e: Exception) {
            emit(Resource.error(null, e.localizedMessage ?: "unknown error"))
        }
    }

}