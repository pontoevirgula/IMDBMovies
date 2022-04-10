package com.chslcompany.imdbmovies.view.home

data class RequestStatus(val status : Status, val message: String? = null){
    companion object{
        val SUCCESS = RequestStatus(Status.SUCCESS)
        val LOADING = RequestStatus(Status.RUNNING)
        fun error(message: String?) = RequestStatus(Status.FAILED, message)
    }

    enum class Status {
        RUNNING,
        SUCCESS,
        FAILED
    }
}