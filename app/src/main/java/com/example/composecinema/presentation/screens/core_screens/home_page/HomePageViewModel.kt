package com.example.composecinema.presentation.screens.core_screens.home_page

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.composecinema.core.OperationStatus
import com.example.composecinema.domain.use_cases.auth_use_case.GetUserNameUseCase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class HomePageViewModel(
    private val getUserNameUseCase: GetUserNameUseCase
) : ViewModel() {

    private val _viewState = MutableStateFlow((HomePageState()))
    val viewState = _viewState.asStateFlow()

    fun onEvent(event: HomePageEvent) {
        when (event) {
            HomePageEvent.OnSearchClick -> {
                _viewState.value = _viewState.value.copy(navigateToSearchScreen = true)
            }

            is HomePageEvent.LoadUser -> {
                getUserName()
            }

            HomePageEvent.ResetNavigation -> {
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
