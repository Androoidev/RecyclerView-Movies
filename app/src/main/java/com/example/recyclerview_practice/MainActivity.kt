package com.example.recyclerview_practice

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.recyclerview_practice.adapter.MovieAdapter
import com.example.recyclerview_practice.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        initRecyclerView()
    }

    private fun initRecyclerView() {
        val manager = LinearLayoutManager(this)
        binding.rvMovies.layoutManager = manager
        binding.rvMovies.adapter = MovieAdapter(MovieProvider.movieList, {onItemSelected(it)})
    }

    private fun onItemSelected(movie: Movie) {
        Toast.makeText(this,movie.movieName,Toast.LENGTH_SHORT).show()
    }
}
