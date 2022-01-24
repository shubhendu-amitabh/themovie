package com.shubhendu.movie.ui.movie.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shubhendu.movie.networking.ApiInterface
import com.shubhendu.movie.ui.movie.list.Movie
import com.shubhendu.movie.utils.Constants.Params.API_KEY
import com.shubhendu.movie.utils.Constants.Params.LANGUAGE
import com.shubhendu.movie.utils.Constants.Params.PAGE
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieDetailsRepository {
    private val movieDetails = MutableLiveData<MovieDetails>()
    val error = MutableLiveData<String>()

    fun getMovieDetails(): LiveData<MovieDetails> {
        loadMovieDetails()
        return movieDetails
    }

    private fun loadMovieDetails(){
        val apiInterface = ApiInterface.create().getMovies(API_KEY, LANGUAGE, PAGE)
        apiInterface.enqueue( object : Callback<List<Movie>> {
            override fun onResponse(call: Call<List<Movie>>?, response: Response<List<Movie>>?) {
                if(response?.body() != null){
                    //
                }
            }

            override fun onFailure(call: Call<List<Movie>>?, t: Throwable?) {

            }
        })
    }
}