package com.chslcompany.imdbmovies.view.detail

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.chslcompany.imdbmovies.BuildConfig.IMAGE
import com.chslcompany.imdbmovies.databinding.ActivityDetailBinding
import com.chslcompany.imdbmovies.model.Favorite
import com.chslcompany.imdbmovies.model.Results
import org.koin.androidx.viewmodel.ext.android.viewModel

class DetailActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDetailBinding
    private val viewModel by viewModel<DetailViewModel>()
    private var movie: Results? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowTitleEnabled(false)

        intent.let {
            movie = it.getSerializableExtra(EXTRA_RESULTS) as Results
        }
    }

    override fun onResume() {
        super.onResume()

        movie?.id?.let { viewModel.checkFavorite(movie?.id.toString())}
        viewModel.checkFavorite(movie?.id.toString()).observe(this) { movie ->
            if (movie != null) {
                showCheck()
            } else {
                hideCheck()
            }
        }

        Glide.with(this)
            .load(IMAGE +movie?.poster_path)
            .into(binding.ivDetailImage)

        Glide.with(this)
            .load(IMAGE +movie?.backdrop_path)
            .into(binding.ivDetailImageBlur)

        binding.tvDetailTitle.text = movie?.title

        binding.btDetailFavorite.setOnClickListener {
            movie?.id?.let { movieId ->
                val favorite = Favorite(movieId)
                viewModel.addFavorite(favorite)
            }
        }

        binding.btDetailFavoriteCheck.setOnClickListener {
            movie?.id?.let { movieId ->
                viewModel.removeFavorite(movieId.toString())
            }
        }

    }

    private fun showCheck(){
        binding.btDetailFavoriteCheck.visibility = View.VISIBLE
        binding.btDetailFavorite.visibility = View.INVISIBLE
    }

    private fun hideCheck(){
        binding.btDetailFavorite.visibility = View.VISIBLE
        binding.btDetailFavoriteCheck.visibility = View.INVISIBLE
    }

    companion object {
        private const val EXTRA_RESULTS = "EXTRA_RESULTS"

        fun getStartIntent(context: Context, results : Results): Intent {
            return Intent(context, DetailActivity::class.java).apply {
                putExtra(EXTRA_RESULTS, results)
            }
        }
    }
}




