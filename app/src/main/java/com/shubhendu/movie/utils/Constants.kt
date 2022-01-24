package com.shubhendu.movie.utils

class Constants {

    object MIMEType {
        const val IMAGE = "image/png"
        const val JSON = "application/json"
    }

    object RequestParams {
        const val CONTENT_TYPE_KEY = "Content-Type"
        const val AUTHORIZATION_KEY = "Authorization"
        const val FORMAT_KEY = "format"
        const val KEY = "api_key"
        const val LANGUAGE_KEY = "language"
        const val PAGE_KEY = "page"
        const val MOVIE_ID_KEY = "movieId"
    }

    object Params {
        val API_KEY = "25a2d34452da2b3f1c3451a0369b962c"
        val LANGUAGE = "en-US"
        val PAGE = "1"
    }

    object RequestURLEndPoints {
        const val BASE_URL = "https://api.themoviedb.org/3/movie"
        const val TOP_RATED_URL = "/top_rated"
        const val RECOMMENDATIONS_URL = "/recommendations"
        const val MOVIE_ID_URL = "/{movieId}"
    }

    // Movie list
    // https://api.themoviedb.org/3/movie/top_rated?api_key=25a2d34452da2b3f1c3451a0369b962c&language=en-US&page=1

    // Movie details
    //https://api.themoviedb.org/3/movie/19404?api_key=25a2d34452da2b3f1c3451a0369b962c&language=en-US

    // Recommended Movies:
    //https://api.themoviedb.org/3/movie/19404/recommendations?api_key=25a2d34452da2b3f1c3451a0369b962c&language=en-US&page=1
}