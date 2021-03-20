package com.mandarine.watchnow.data.local

import com.mandarine.watchnow.data.model.Movie
import com.mandarine.watchnow.data.model.MoviePreview

interface MoviesRepository {
    fun getMovieById(id: Int): Movie
    fun getAllPreviews(): List<MoviePreview>
}