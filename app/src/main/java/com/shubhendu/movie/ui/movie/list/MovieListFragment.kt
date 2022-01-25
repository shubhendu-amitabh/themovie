package com.shubhendu.movie.ui.movie.list

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import com.shubhendu.movie.R
import com.shubhendu.movie.ui.movie.list.model.Movie

class MovieListFragment : Fragment() {

    var movies:List<Movie>? = null

    companion object {
        fun newInstance() = MovieListFragment()
    }

    lateinit var rootView: View
    private lateinit var viewModel: MovieListViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.movie_list_fragment, container, false)
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MovieListViewModel::class.java)
        viewModel.getMovieList().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                movies = it
            } else {
            }
        })
    }
}