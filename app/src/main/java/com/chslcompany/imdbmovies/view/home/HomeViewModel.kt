package com.chslcompany.imdbmovies.view.home

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.chslcompany.imdbmovies.core.util.RequestStatus
import com.chslcompany.imdbmovies.model.Results
import com.chslcompany.imdbmovies.repository.MovieRepository
import kotlinx.coroutines.launch
import java.lang.Exception

class HomeViewModel(private val repository: MovieRepository)
    :ViewModel(){

    private val _text = MutableLiveData<String>().apply {
         value = "Esta é a HomeFragment"
     }

    val text: LiveData<String> = _text

    var moviesLiveData: MutableLiveData<List<Results>> = MutableLiveData()

    private val _requestStatus = MutableLiveData<RequestStatus>()
    val requestStatus: MutableLiveData<RequestStatus>
        get() = _requestStatus

    init {
        fetchMovies()
    }

    private fun fetchMovies() {
        viewModelScope.launch {
            try{
                _requestStatus.postValue(RequestStatus.LOADING)
                val listMovies = repository.getMovies()

                if (listMovies.isNullOrEmpty().not()){
                    val movies : MutableList<Results> = mutableListOf()
                    if (listMovies != null) {
                        movies.addAll(listMovies)
                    }
                    moviesLiveData.value = movies
                    _requestStatus.postValue(RequestStatus.SUCCESS)
                }
            }catch (e: Exception){
                _requestStatus.postValue(RequestStatus.error(e.message ?: ""))
                Log.e(FAIL,e.message ?: "")
            }
        }
    }

    companion object{
        private const val FAIL = "Erro ao buscar filme"
    }
}