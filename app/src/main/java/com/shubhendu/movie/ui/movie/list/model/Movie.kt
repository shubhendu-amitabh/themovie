package com.shubhendu.movie.ui.movie.list.model

data class Movie(
    var adult:Boolean,
    var backdrop_path: String,
    var genre_ids: ArrayList<Int>,
    var id:Int,
    var media_type: String,
    var title: String,
    var original_language: String?,
    var original_title: String,
    var overview: String?,
    var popularity:Float,
    var poster_path: String?,
    var release_date: String?,
    var video:Boolean,
    var vote_average:Float,
    var vote_count:Int
)