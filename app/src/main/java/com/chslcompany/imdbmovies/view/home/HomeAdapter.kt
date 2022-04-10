package com.chslcompany.imdbmovies.view.home

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.chslcompany.imdbmovies.BuildConfig
import com.chslcompany.imdbmovies.databinding.AdapterMovieItemBinding
import com.chslcompany.imdbmovies.model.Results

class HomeAdapter(private val movies: MutableList<Results>,
                  private val onItemClick: (resultList : Results) -> Unit) : RecyclerView.Adapter<HomeAdapter.MovieViewHolder>() {

    private lateinit var binding: AdapterMovieItemBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        binding = AdapterMovieItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MovieViewHolder(binding, onItemClick)
    }

    fun replaceAllMovies(movieList: List<Results>) {
        movies.clear()
        movies.addAll(movieList)
        notifyDataSetChanged()
    }

    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        holder.bind(movies[position])
    }

    override fun getItemCount() = movies.size

    inner class MovieViewHolder(
        private val binding: AdapterMovieItemBinding,
        private val onItemClick: (resultList : Results) -> Unit
    ) : RecyclerView.ViewHolder(binding.root) {


        fun bind(results: Results) {
            val image = BuildConfig.IMAGE + results.poster_path
            Glide.with(itemView)
                .load(image)
                .into(binding.ivMovieImage)

            itemView.setOnClickListener {
                onItemClick.invoke(results)
            }
        }
    }
}