package com.example.mvvmexample.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.mvvmexample.R
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: MainViewModel by viewModel()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupViewModel()
    }

    private fun setupViewModel() {
        viewModel.loadFilms()
        viewModel.toast.observeForever {
            Toast.makeText(this, it, Toast.LENGTH_LONG).show()
        }
        viewModel.filmLD.observe(this) { list ->
            var result = ""
            list.forEach { result += it.toString() }
            findViewById<TextView>(R.id.text_view).text = result
        }
    }


}



