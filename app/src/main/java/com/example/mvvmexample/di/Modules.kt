package com.example.mvvmexample.di

import com.example.mvvmexample.data.network.RetrofitClient
import com.example.mvvmexample.data.repository.FilmsRepository
import com.example.mvvmexample.ui.main.MainViewModel
import org.koin.dsl.module

val networkModule = module {
    factory { RetrofitClient().instanceRetrofit() }
}

val repositoryModule = module {
    factory { FilmsRepository(get()) }
}

val viewModelModule = module {
    factory { MainViewModel(get()) }
}