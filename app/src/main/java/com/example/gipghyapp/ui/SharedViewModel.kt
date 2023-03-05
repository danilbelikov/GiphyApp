package com.example.gipghyapp.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.gipghyapp.models.Data
import kotlinx.coroutines.launch

class SharedViewModel : ViewModel() {
    private val _shared = MutableLiveData<Data>()
    val shared: LiveData<Data>
        get() = _shared

    fun setShared(data: Data) = viewModelScope.launch {
        _shared.postValue(data)
    }
}