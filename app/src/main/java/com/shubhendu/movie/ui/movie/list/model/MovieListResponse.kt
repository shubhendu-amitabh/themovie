package com.shubhendu.movie.ui.movie.list.model

data class MovieListResponse(var page: Int,
                             var results: List<Movie>,
                             var total_pages: Int,
                             var total_results: Int)
