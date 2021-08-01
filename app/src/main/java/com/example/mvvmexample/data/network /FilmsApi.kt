package com.example.mvvmexample.data.network

import com.example.mvvmexample.models.FilmModel
import retrofit2.http.GET
import retrofit2.http.Path

interface FilmsApi {

    @GET("films")
    suspend fun getFilms(): MutableList<FilmModel>

    @GET("films/{id}")
    suspend fun getFilmById(@Path("id") id: String): FilmModel

}