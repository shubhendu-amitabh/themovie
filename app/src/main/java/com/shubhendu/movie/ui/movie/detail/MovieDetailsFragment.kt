package com.shubhendu.movie.ui.movie.detail

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.shubhendu.movie.R
import com.shubhendu.movie.ui.movie.detail.model.MovieDetails
import com.shubhendu.movie.ui.movie.list.MovieListViewModel
import com.shubhendu.movie.ui.movie.list.model.Movie

class MovieDetailsFragment : Fragment() {

    var recommendedMovies:List<Movie>? = null
    var movieDetails:MovieDetails? = null

    companion object {
        fun newInstance() = MovieDetailsFragment()
    }

    private lateinit var viewModel: MovieDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.movie_details_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MovieDetailsViewModel::class.java)
        viewModel.getMovieDetails(11854).observe(viewLifecycleOwner, Observer {
            if (it != null) {
                movieDetails = it
            } else {
            }
        })

        viewModel.getMovieRecommendations(11854).observe(viewLifecycleOwner, Observer {
            if (it != null) {
                recommendedMovies = it
            } else {
            }
        })
    }
}