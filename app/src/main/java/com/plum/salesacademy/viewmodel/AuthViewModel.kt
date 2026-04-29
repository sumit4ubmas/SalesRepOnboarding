package com.plum.salesacademy.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.plum.salesacademy.data.repository.PlumRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class AuthViewModel(private val repository: PlumRepository) : ViewModel() {
    private val _status = MutableStateFlow("idle")
    val status: StateFlow<String> = _status
    fun login(identifier: String) = viewModelScope.launch {
        _status.value = repository.login(identifier).status
    }
}
