package com.shubhendu.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shubhendu.movie.ui.movie.detail.MovieDetailsFragment
import com.shubhendu.movie.ui.movie.list.MovieListFragment

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            displayMovieDetailsFragment()
        }
    }

    fun displayMovieListFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MovieListFragment.newInstance())
            .commitNow()
    }

    fun displayMovieDetailsFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MovieDetailsFragment.newInstance())
            .commitNow()
    }
}