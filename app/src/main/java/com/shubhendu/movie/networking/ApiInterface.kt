package com.shubhendu.movie.networking

import com.shubhendu.movie.ui.movie.detail.MovieDetails
import com.shubhendu.movie.ui.movie.list.Movie
import com.shubhendu.movie.utils.Constants.RequestParams.KEY
import com.shubhendu.movie.utils.Constants.RequestParams.LANGUAGE_KEY
import com.shubhendu.movie.utils.Constants.RequestParams.MOVIE_ID_KEY
import com.shubhendu.movie.utils.Constants.RequestParams.PAGE_KEY
import com.shubhendu.movie.utils.Constants.RequestURLEndPoints.BASE_URL
import com.shubhendu.movie.utils.Constants.RequestURLEndPoints.MOVIE_ID_URL
import com.shubhendu.movie.utils.Constants.RequestURLEndPoints.RECOMMENDATIONS_URL
import com.shubhendu.movie.utils.Constants.RequestURLEndPoints.TOP_RATED_URL
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    // Get movie list
    @GET(TOP_RATED_URL)
    fun getMovies(@Query(KEY) apiKey:String,
                  @Query(LANGUAGE_KEY) language:String,
                  @Query(PAGE_KEY) page:String,
                  ) : Call<List<Movie>>

    // Get movie details
    @GET(MOVIE_ID_URL)
    fun getMovieDetails(@Path(MOVIE_ID_KEY)  userId:String,
                        @Query(KEY) apiKey:String,
                        @Query(LANGUAGE_KEY) language:String,
                        @Query(PAGE_KEY) page:String,
    ) : Call<MovieDetails>

    // Get movie recommendations
    @GET(RECOMMENDATIONS_URL)
    fun getMovieRecommendations(@Query(KEY) apiKey:String,
                        @Query(LANGUAGE_KEY) language:String,
                        @Query(PAGE_KEY) page:String,
    ) : Call<MovieDetails>

    companion object {

        fun create() : ApiInterface {
            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}
