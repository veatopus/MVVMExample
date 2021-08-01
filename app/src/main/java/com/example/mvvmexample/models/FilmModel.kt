package com.example.mvvmexample.models

data class FilmModel (
    val description: String,
    val director: String,
    val id: String,
    val locations: List<String>,
    val original_title: String,
    val original_title_romanised: String,
    val people: List<String>,
    val producer: String,
    val release_date: String,
    val rt_score: String,
    val running_time: String,
    val species: List<String>,
    val title: String,
    val url: String,
    val vehicles: List<String>
) {
    override fun toString(): String {
        return "FilmModel(description='$description', director='$director', id='$id', locations=$locations, original_title='$original_title', original_title_romanised='$original_title_romanised', people=$people, producer='$producer', release_date='$release_date', rt_score='$rt_score', running_time='$running_time', species=$species, title='$title', url='$url', vehicles=$vehicles) \n\n\n\n\n"
    }
}