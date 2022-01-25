package com.shubhendu.movie.ui.movie.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.shubhendu.movie.ui.movie.detail.model.MovieDetails
import com.shubhendu.movie.ui.movie.list.model.Movie

class MovieDetailsViewModel : ViewModel() {

    var recommendedMovies = MutableLiveData<List<Movie>>()
    var recommendedMoviesError = MutableLiveData<String>()

    var movieDetails = MutableLiveData<MovieDetails>()
    var error = MutableLiveData<String>()
    var showLoader: LiveData<Boolean>

    private val movieDetailsRepository = MovieDetailsRepository()

    init {
        this.movieDetails  = movieDetailsRepository.movieDetails
        this.error = movieDetailsRepository.error

        this.recommendedMovies  = movieDetailsRepository.recommendedMovies
        this.recommendedMoviesError = movieDetailsRepository.recommendedMoviesError

        this.showLoader  = movieDetailsRepository.showLoader

    }

    fun getMovieDetails(movieId:Int): MutableLiveData<MovieDetails> {
        movieDetails = movieDetailsRepository.getMovieDetails(movieId)
        return movieDetails
    }

    fun getMovieRecommendations(movieId:Int): MutableLiveData<List<Movie>> {
        recommendedMovies = movieDetailsRepository.getMovieRecommendations(movieId)
        return recommendedMovies
    }
}