package com.shubhendu.movie.ui.movie.detail.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.shubhendu.movie.MainActivity
import com.shubhendu.movie.R
import com.shubhendu.movie.ui.movie.list.model.Movie
import com.shubhendu.movie.utils.Constants

class HorizontalAdapter(context: Context, val movies:List<Movie>) :
    RecyclerView.Adapter<HorizontalAdapter.MyView>() {

    private var context: Context? = context

    class MyView(view: View) : RecyclerView.ViewHolder(view) {
        var imageView: ImageView
        init {
            imageView = view
                .findViewById<ImageView>(R.id.image)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyView {
        val itemView: View = LayoutInflater
            .from(parent.context)
            .inflate(
                R.layout.item_recommendation,
                parent,
                false
            )
        return MyView(itemView)
    }

    override fun onBindViewHolder(holder: MyView, position: Int) {
        val movie = movies[position]

        holder.itemView.setOnClickListener(View.OnClickListener {
            (context as MainActivity).displayMovieDetailsFragment(movie.id)
        })

        context?.let {
            Glide.with(it)
                .load(Constants.RequestURLEndPoints.IMAGE_BASE_URL +movie.poster_path)
                .fitCenter()
                .into(holder.imageView)
        }
    }

    override fun getItemCount(): Int {
        return movies.size
    }

}