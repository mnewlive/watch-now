package com.mandarine.watchnow.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mandarine.watchnow.data.local.FakeRepository
import com.mandarine.watchnow.data.model.Movie
import com.mandarine.watchnow.data.model.MoviePreview
import com.mandarine.watchnow.utils.Resource
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainViewModel() : ViewModel() {

    private val _moviesPreview = MutableLiveData<Resource<List<MoviePreview>>>()
    val moviesPreview: LiveData<Resource<List<MoviePreview>>> = _moviesPreview

    private val _movie = MutableLiveData<Resource<Movie>>()
    val movie: LiveData<Resource<Movie>> = _movie

    init {
        viewModelScope.launch {
            _moviesPreview.postValue(Resource.loading(null))
            delay(2000L)
            _moviesPreview.postValue(Resource.success(FakeRepository.getAllPreviews()))
        }
    }

    fun getMovie(id: Int) {
        viewModelScope.launch {
            _movie.postValue(Resource.loading(null))
            delay(2000)
            _movie.postValue(Resource.success(FakeRepository.getMovieById(id)))
        }
    }
}