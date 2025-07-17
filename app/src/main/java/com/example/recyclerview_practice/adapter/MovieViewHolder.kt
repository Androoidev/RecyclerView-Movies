package com.example.recyclerview_practice.adapter

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.recyclerview_practice.Movie
import com.example.recyclerview_practice.databinding.ItemMovieBinding

class MovieViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val binding = ItemMovieBinding.bind(view)

    fun render(movieModel: Movie){
        binding.tvMovieName.text = movieModel.movieName
        binding.tvMovieYear.text = movieModel.year.toString()
        binding.tvMovieDirector.text = movieModel.director
        Glide.with(binding.ivMovie.context).load(movieModel.photo).into(binding.ivMovie)
    }
}