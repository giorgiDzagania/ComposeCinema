package com.example.composecinema.presentation.screens.mainPage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecinema.core.OperationStatus
import com.example.composecinema.domain.useCases.userDetailsUseCases.GetUserNameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class MainPageViewModel(
    private val getUserNameUseCase: GetUserNameUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow((MainPageState()))
    val viewState = _viewState.asStateFlow()

    fun onEvent(event: MainPageEvent) {
        when (event) {
            MainPageEvent.OnSearchClick -> {
                _viewState.value = _viewState.value.copy(navigateToSearchScreen = true)
            }

            is MainPageEvent.LoadUser -> {
                getUserName()
            }

            MainPageEvent.ResetNavigation -> {
                _viewState.value= _viewState.value.copy(navigateToSearchScreen = false)
            }
        }
    }

    private fun getUserName() {
        viewModelScope.launch {
            _viewState.value = _viewState.value.copy(loading = true)
            when (val status = getUserNameUseCase()) {
                is OperationStatus.Success -> {
                    _viewState.value = _viewState.value.copy(
                        userName = status.value,
                        loading = false
                    )
                }

                is OperationStatus.Failure -> {
                    _viewState.value = _viewState.value.copy(
                        loading = false,
                        errorMessage = status.exception.message.toString()
                    )
                }
            }
        }
    }



}
