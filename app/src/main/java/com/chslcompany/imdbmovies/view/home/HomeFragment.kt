package com.chslcompany.imdbmovies.view.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.chslcompany.imdbmovies.R
import com.chslcompany.imdbmovies.core.util.SpacingItemDecoration
import com.chslcompany.imdbmovies.databinding.FragmentHomeBinding
import com.chslcompany.imdbmovies.view.detail.DetailActivity
import org.koin.androidx.viewmodel.ext.android.viewModel


class HomeFragment : Fragment() {

    private val viewModel by viewModel<HomeViewModel>()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel.moviesLiveData.observe(this) { movies ->
            if (!movies.isNullOrEmpty()) {
                binding.rvHome.layoutManager = GridLayoutManager(activity, 3)
                val spacingInPixels = resources.getDimensionPixelSize(R.dimen.grid4)
                binding.rvHome.addItemDecoration(SpacingItemDecoration(spacingInPixels))

                val adapter = HomeAdapter(mutableListOf()) { movieClicked ->
                    val intent = DetailActivity.getStartIntent(requireContext(), movieClicked)
                    startActivity(intent)
                }
                adapter.replaceAllMovies(movies)
                binding.rvHome.adapter = adapter
            }
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}