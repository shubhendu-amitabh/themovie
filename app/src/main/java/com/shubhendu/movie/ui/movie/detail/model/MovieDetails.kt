package com.shubhendu.movie.ui.movie.detail.model

data class MovieDetails(
    var adult:Boolean,
    var backdrop_path: String?,
    var belongs_to_collection: Any?,
    var budget:Int,
    var genres: ArrayList<Genre>?,
    var homepage: String?,
    var id:Int,
    var imdb_id: String?,
    var original_language: String?,
    var original_title: String?,
    var overview: String?,
    var popularity:Float,
    var poster_path: String?,
    var production_companies: ArrayList<ProductionCompany>?,
    var production_countries: ArrayList<ProductionCountry>?,
    var release_date: String?,
    var revenue:Int,
    var runtime:Int,
    var spoken_languages: ArrayList<SpokenLanguage>?,
    var status: String?,
    var tagline: String?,
    var title: String?,
    var video:Boolean,
    var vote_average:Float,
    var vote_count:Int
)