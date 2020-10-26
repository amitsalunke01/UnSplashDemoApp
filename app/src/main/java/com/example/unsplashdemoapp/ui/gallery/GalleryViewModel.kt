package com.example.unsplashdemoapp.ui.gallery

import android.util.Log
import androidx.hilt.Assisted
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.*
import androidx.paging.cachedIn
import com.example.unsplashdemoapp.data.UnsplashRepository

class GalleryViewModel @ViewModelInject constructor(
    private val repository: UnsplashRepository,
    @Assisted state: SavedStateHandle
) :
    ViewModel() {

    companion object {
        private const val CURRENT_QUERY = "current_query"
        private const val DEFAULT_QUERY = "motorcycle"
    }

    //SavedStateHandle is very use full when app process thread is killed in the background by the system, so this state will handle the previous state
    private val currentQuery =
        state.getLiveData(CURRENT_QUERY, DEFAULT_QUERY)//MutableLiveData(DEFAULT_QUERY)

    val photos = currentQuery.switchMap { it ->
        Log.e("ViewModel", "switch map triggered" + currentQuery.value)
        repository.getSearchResults(it).cachedIn(viewModelScope)
    }

    fun searchPhotos(query: String) {
        currentQuery.value = query
    }


    //older which does not uses state
    /*companion object {
        private const val DEFAULT_QUERY = "motorcycle"
    }

    private val currentQuery = MutableLiveData(DEFAULT_QUERY)

    val photos = currentQuery.switchMap { it ->
        Log.e("ViewModel", "switch map triggered" + currentQuery.value)
        repository.getSearchResults(it).cachedIn(viewModelScope)
    }

    fun searchPhotos(query: String) {
        currentQuery.value = query
    }*/

}