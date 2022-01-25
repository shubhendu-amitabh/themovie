package com.shubhendu.movie.ui.movie.list.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shubhendu.movie.MainActivity
import com.shubhendu.movie.R
import com.shubhendu.movie.ui.movie.list.model.Movie
import com.shubhendu.movie.utils.Constants.RequestURLEndPoints.IMAGE_BASE_URL

class MoviesAdapter (context: Context,
                     private val movies: List<Movie>) : RecyclerView.Adapter<MoviesAdapter.ViewHolder>() {

    private var context: Context? = context

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val titleTextView: TextView = itemView.findViewById<TextView>(R.id.movieTitle)
        val movieImageView = itemView.findViewById<ImageView>(R.id.movieImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoviesAdapter.ViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        val contactView = inflater.inflate(R.layout.item_movie, parent, false)
        return ViewHolder(contactView)
    }

    override fun onBindViewHolder(viewHolder: MoviesAdapter.ViewHolder, position: Int) {
        val movie: Movie = movies[position]
        viewHolder.titleTextView.text = movie.title

        viewHolder.itemView.setOnClickListener(View.OnClickListener {
            (context as MainActivity).displayMovieDetailsFragment()
        })

        context?.let {
            Glide.with(it)
                .load(IMAGE_BASE_URL+movie.poster_path)
                .fitCenter()
                .into(viewHolder.movieImageView)
        };
    }

    // Returns the total count of items in the list
    override fun getItemCount(): Int {
        return movies.size
    }
}