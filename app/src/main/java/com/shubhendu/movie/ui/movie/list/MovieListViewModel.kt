package com.shubhendu.movie.ui.movie.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shubhendu.movie.ui.movie.list.model.Movie

class MovieListViewModel : ViewModel() {

    private var movies = MutableLiveData<List<Movie>>()
    var error: LiveData<String>
    var showLoader: LiveData<Boolean>

    private val movieListRepository = MovieListRepository()

    init {
        this.movies  = movieListRepository.movies
        this.error = movieListRepository.error
        this.showLoader  = movieListRepository.showLoader
    }

    fun getMovieList(): MutableLiveData<List<Movie>> {
        movies = movieListRepository.getMovieList()
        return movies
    }
}