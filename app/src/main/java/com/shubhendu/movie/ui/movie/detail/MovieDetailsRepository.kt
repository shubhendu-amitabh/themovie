package com.shubhendu.movie.ui.movie.detail

import androidx.lifecycle.MutableLiveData
import com.shubhendu.movie.networking.ApiInterface
import com.shubhendu.movie.ui.movie.detail.model.MovieDetails
import com.shubhendu.movie.ui.movie.list.model.Movie
import com.shubhendu.movie.ui.movie.list.model.MovieListResponse
import com.shubhendu.movie.utils.Constants.Params.API_KEY
import com.shubhendu.movie.utils.Constants.Params.LANGUAGE
import com.shubhendu.movie.utils.Constants.Params.PAGE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailsRepository {
    val recommendedMovies = MutableLiveData<List<Movie>>()
    val recommendedMoviesError = MutableLiveData<String>()

    val movieDetails = MutableLiveData<MovieDetails>()
    val error = MutableLiveData<String>()
    val showLoader = MutableLiveData<Boolean>()

    fun getMovieDetails(movieId:Int): MutableLiveData<MovieDetails> {
        loadMovieDetails(movieId)
        return movieDetails
    }

    private fun loadMovieDetails(movieId:Int){
        val apiInterface = ApiInterface.create().getMovieDetails(movieId, API_KEY, LANGUAGE, PAGE)
        apiInterface.enqueue( object : Callback<MovieDetails> {
            override fun onResponse(call: Call<MovieDetails>?, response: Response<MovieDetails>?) {
                if(response?.body() != null){
                    movieDetails.value = response?.body()
                }
            }

            override fun onFailure(call: Call<MovieDetails>?, t: Throwable) {
                error.value = t.localizedMessage
            }
        })
    }

    fun getMovieRecommendations(movieId:Int): MutableLiveData<List<Movie>> {
        loadMovieRecommendations(movieId)
        return recommendedMovies
    }

    private fun loadMovieRecommendations(movieId:Int){
        val apiInterface = ApiInterface.create().getMovieRecommendations(movieId, API_KEY, LANGUAGE, PAGE)
        apiInterface.enqueue( object : Callback<MovieListResponse> {
            override fun onResponse(call: Call<MovieListResponse>?, response: Response<MovieListResponse>?) {
                if(response?.body() != null){
                    recommendedMovies.value = response?.body()?.results
                }
            }

            override fun onFailure(call: Call<MovieListResponse>?, t: Throwable) {
                recommendedMoviesError.value = t.localizedMessage
            }
        })
    }
}