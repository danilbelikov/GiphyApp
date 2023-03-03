package com.example.gipghyapp.ui.search

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gipghyapp.data.api.TestRepo
import com.example.gipghyapp.models.GiphyResponse2
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class SearchViewModel @Inject constructor(private val repository: TestRepo): ViewModel() {
    private val _all = MutableLiveData<GiphyResponse2>()
    val all: LiveData<GiphyResponse2>
    get() = _all

    init {
        getAll()
    }

    fun getAll() = viewModelScope.launch {
        repository.getAll().let {
            if (it.isSuccessful) {
                _all.postValue(it.body())
            } else {
                Log.d("checkData", "Failed to load gifs: ${it.errorBody()}")
            }
        }
    }

}