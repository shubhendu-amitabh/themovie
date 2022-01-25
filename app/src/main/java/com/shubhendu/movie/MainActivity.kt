package com.shubhendu.movie

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.shubhendu.movie.ui.movie.detail.MovieDetailsFragment
import com.shubhendu.movie.ui.movie.list.MovieListFragment

class MainActivity : AppCompatActivity() {

    var currentFragment = "LIST_FRAGMENT"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_activity)
        if (savedInstanceState == null) {
            displayMovieListFragment()
        }
    }

    fun displayMovieListFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MovieListFragment.newInstance())
            .commitNow()
        currentFragment = "LIST_FRAGMENT"
    }

    fun displayMovieDetailsFragment(){
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, MovieDetailsFragment.newInstance())
            .commitNow()
        currentFragment = "DETAILS_FRAGMENT"
    }

    override fun onBackPressed() {
        if (currentFragment =="DETAILS_FRAGMENT"){
            displayMovieListFragment()
        }else{
            super.onBackPressed()
        }
    }
}