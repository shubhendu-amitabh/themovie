package com.shubhendu.movie.ui.movie.detail

import android.content.Context
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shubhendu.movie.R
import com.shubhendu.movie.ui.movie.detail.adapter.HorizontalAdapter
import com.shubhendu.movie.ui.movie.detail.model.MovieDetails
import com.shubhendu.movie.ui.movie.list.MovieListViewModel
import com.shubhendu.movie.ui.movie.list.model.Movie
import com.shubhendu.movie.utils.Constants

class MovieDetailsFragment : Fragment() {

    var recommendedMovies:List<Movie>? = null
    var movieDetails:MovieDetails? = null
    var movieID = 11854

    companion object {
        fun newInstance() = MovieDetailsFragment()
    }

    lateinit var recommendationRecycler: RecyclerView

    lateinit var popularityTextView: TextView
    lateinit var releaseDateTextView: TextView

    lateinit var titleTextView: TextView
    lateinit var imageView: ImageView
    lateinit var rootView: View
    private lateinit var viewModel: MovieDetailsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.movie_details_fragment, container, false)

        popularityTextView = rootView.findViewById<TextView>(R.id.popularity)
        releaseDateTextView = rootView.findViewById<TextView>(R.id.releaseDate)

        titleTextView = rootView.findViewById<View>(R.id.movieTitle) as TextView
        imageView = rootView.findViewById<View>(R.id.posterImage) as ImageView
        recommendationRecycler = rootView.findViewById<RecyclerView>(R.id.recycler)
        recommendationRecycler.layoutManager = LinearLayoutManager(activity, LinearLayoutManager.HORIZONTAL, false)

        movieID = arguments?.get(Constants.RequestParams.MOVIE_ID_KEY) as Int
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MovieDetailsViewModel::class.java)
        viewModel.getMovieDetails(movieID).observe(viewLifecycleOwner, Observer {
            if (it != null) {
                movieDetails = it
                titleTextView.text = movieDetails?.title
                popularityTextView.text = movieDetails!!.popularity.toString()
                releaseDateTextView.text = movieDetails!!.release_date

                activity?.let { it1 ->
                    Glide.with(it1)
                        .load(Constants.RequestURLEndPoints.IMAGE_BASE_URL + movieDetails?.poster_path)
                        .fitCenter()
                        .into(imageView)
                }
            } else {
            }
        })

        viewModel.getMovieRecommendations(movieID).observe(viewLifecycleOwner, Observer {
            if (it != null) {
                recommendedMovies = it
                recommendationRecycler.adapter =
                    activity?.let { it1 -> HorizontalAdapter(it1, recommendedMovies!!) }
            } else {
            }
        })
    }
}