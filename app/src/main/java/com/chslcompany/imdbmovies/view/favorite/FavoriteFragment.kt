package com.chslcompany.imdbmovies.view.favorite

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import com.chslcompany.imdbmovies.R
import com.chslcompany.imdbmovies.core.util.SpacingItemDecoration
import com.chslcompany.imdbmovies.databinding.FragmentFavoriteBinding
import com.chslcompany.imdbmovies.model.Results
import com.chslcompany.imdbmovies.view.detail.DetailActivity
import com.chslcompany.imdbmovies.view.home.HomeAdapter
import org.koin.androidx.viewmodel.ext.android.viewModel

class FavoriteFragment : Fragment() {

    private val viewModel by viewModel<FavoriteViewModel>()
    private var _binding : FragmentFavoriteBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View{
       _binding = FragmentFavoriteBinding.inflate(layoutInflater)
       return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        viewModel.listFavoriteMovies.observe(this){ movies ->
            binding.favoriteRecyclerView.layoutManager = GridLayoutManager(activity, 3)
            val spacingInPixels = resources.getDimensionPixelSize(R.dimen.grid4)
            binding.favoriteRecyclerView.addItemDecoration(
                SpacingItemDecoration(
                    spacingInPixels
                )
            )
            context?.let {
                binding.favoriteRecyclerView.adapter = HomeAdapter(it, movies as MutableList<Results>){ results->
                    val intent = DetailActivity.getStartIntent(it, results)
                    startActivity(intent)
                }

            }
        }
    }

}