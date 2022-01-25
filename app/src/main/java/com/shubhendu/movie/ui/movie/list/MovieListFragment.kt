package com.shubhendu.movie.ui.movie.list

import android.content.Context
import android.media.Image
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.SearchView
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.dinuscxj.refresh.RecyclerRefreshLayout
import com.shubhendu.movie.R
import com.shubhendu.movie.ui.movie.list.adapter.MoviesAdapter
import com.shubhendu.movie.ui.movie.list.model.Movie

class MovieListFragment : Fragment() {

    var movies:List<Movie>? = null

    companion object {
        fun newInstance() = MovieListFragment()
    }


    lateinit var searchView: SearchView
    lateinit var rvMovies: RecyclerView
    lateinit var rootView: View
    lateinit var sortImageView: ImageView
    lateinit var refreshLayout: RecyclerRefreshLayout

    private lateinit var viewModel: MovieListViewModel

    var searchKey = ""
    var defaultSort = true

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        rootView = inflater.inflate(R.layout.movie_list_fragment, container, false)
        rvMovies = rootView.findViewById<View>(R.id.movies) as RecyclerView
        searchView = rootView.findViewById<SearchView>(R.id.searchView) as SearchView
        sortImageView = rootView.findViewById(R.id.sort) as ImageView
        refreshLayout = rootView.findViewById(R.id.refresh_layout) as RecyclerRefreshLayout
        refreshLayout.setOnRefreshListener {
            loadData()
        }

        sortImageView.setOnClickListener(View.OnClickListener {
            defaultSort = !defaultSort
            populateList()
        })

        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(item: String?): Boolean {
                if (item != null) {
                    searchKey = item
                    populateList()
                }
                return false
            }
            override fun onQueryTextChange(item: String?): Boolean {
                if (item != null) {
                    searchKey = item
                    populateList()
                }
                return false
            }
        })
        return rootView
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProvider(this).get(MovieListViewModel::class.java)
        loadData()
    }

    private fun loadData(){
        searchKey = ""
        defaultSort = true
        viewModel.getMovieList().observe(viewLifecycleOwner, Observer {
            if (it != null) {
                movies = it
                populateList()
                val adapter = movies?.let { activity?.let { it1 -> MoviesAdapter(it1, it) } }
                rvMovies.adapter = adapter
                rvMovies.layoutManager = LinearLayoutManager(activity)
            } else {
            }
        })
    }

    fun populateList(){
        var filteredMovies = ArrayList<Movie>()

        // Perform search operation
        if (searchKey.length>0){
            for (movie in movies!!) {
                if (movie.title.contains(searchKey, ignoreCase = true)){
                    filteredMovies.add(movie)
                }
            }
        }else{
            filteredMovies = movies as ArrayList<Movie>
        }

        // Perform sort operation
        if (defaultSort){
            filteredMovies.sortBy { it.title }
        }else{
            filteredMovies.sortByDescending { it.title }
        }

        refreshLayout.setRefreshing(false)
        val adapter = filteredMovies?.let { activity?.let { it1 -> MoviesAdapter(it1, it) } }
        rvMovies.adapter = adapter
        rvMovies.layoutManager = LinearLayoutManager(activity)
    }
}