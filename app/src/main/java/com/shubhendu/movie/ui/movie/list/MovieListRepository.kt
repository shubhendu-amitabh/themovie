package com.shubhendu.movie.ui.movie.list

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.shubhendu.movie.networking.ApiInterface
import com.shubhendu.movie.utils.Constants
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MovieListRepository {

    val movies = MutableLiveData<List<Movie>>()
    val error = MutableLiveData<String>()
    val showLoader = MutableLiveData<Boolean>()

    fun getMovieList():LiveData<List<Movie>>{
        loadMovieList()
        return movies
    }

    private fun loadMovieList(){
        val apiInterface = ApiInterface.create().getMovies(
            Constants.Params.API_KEY,
            Constants.Params.LANGUAGE,
            Constants.Params.PAGE
        )
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