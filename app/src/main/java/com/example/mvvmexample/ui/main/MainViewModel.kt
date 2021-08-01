package com.example.mvvmexample.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmexample.data.network.Status
import com.example.mvvmexample.data.repository.FilmsRepository
import com.example.mvvmexample.models.FilmModel

class MainViewModel(private val repository: FilmsRepository): ViewModel() {

    private var _toast = MutableLiveData<String>()
    var toast: LiveData<String> = _toast
    private var _filmsLD = MutableLiveData<MutableList<FilmModel>>()
    var filmLD: LiveData<MutableList<FilmModel>> = _filmsLD

    fun loadFilms() {
        repository.getFilms().observeForever {
            when(it.status) {
                Status.LOADING -> _toast.postValue("is loading")
                Status.ERROR -> _toast.postValue(it.message ?: "")
                Status.SUCCESS -> {
                    _filmsLD.postValue(it.data!!)
                    _toast.postValue("successful")
                }
            }
        }
    }
}