package com.shubhendu.movie.ui.movie.list

import androidx.lifecycle.MutableLiveData
import com.shubhendu.movie.networking.ApiInterface
import com.shubhendu.movie.ui.movie.list.model.Movie
import com.shubhendu.movie.ui.movie.list.model.MovieListResponse
import com.shubhendu.movie.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListRepository {

    val movies = MutableLiveData<List<Movie>>()
    val error = MutableLiveData<String>()
    val showLoader = MutableLiveData<Boolean>()

    fun getMovieList():MutableLiveData<List<Movie>>{
        loadMovieList()
        return movies
    }

    private fun loadMovieList(){
        val apiInterface = ApiInterface.create().getMovies(
            Constants.Params.API_KEY,
            Constants.Params.LANGUAGE,
            Constants.Params.PAGE
        )
        apiInterface.enqueue( object : Callback<MovieListResponse> {
            override fun onResponse(call: Call<MovieListResponse>?, response: Response<MovieListResponse>?) {
                    movies.value = response?.body()?.results
            }

            override fun onFailure(call: Call<MovieListResponse>?, t: Throwable) {
                error.value = t.localizedMessage
            }
        })
    }
}