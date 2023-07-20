package com.bendingbuddies.feature.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bendingbuddies.core.common.NetworkResponseState
import com.bendingbuddies.core.domain.usecase.GetAllBendingBuddiesUseCase
import com.bendingbuddies.core.domain.usecase.GetBendingBuddyByNameUseCase
import com.bendingbuddies.core.presentation.model.home.HomeUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.bendingbuddies.core.presentation.R as corePresentationRes

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllBendingBuddiesUseCase: GetAllBendingBuddiesUseCase,
    private val getBendingBuddyByNameUseCase: GetBendingBuddyByNameUseCase,
    private val bendingBuddyListMapper: BendingBuddyHomeUiMapperImpl
) : ViewModel() {

    private val _bendingBuddyHomeUiState = MutableLiveData<HomeUiState>()
    val bendingBuddyHomeUiState: LiveData<HomeUiState> get() = _bendingBuddyHomeUiState

    fun getAllBendingBuddies() {
        viewModelScope.launch {
            getAllBendingBuddiesUseCase().collect {
                when (it) {

                    is NetworkResponseState.Error -> {
                        _bendingBuddyHomeUiState.postValue(
                            HomeUiState.Error(corePresentationRes.string.unknown_error)
                        )
                    }

                    NetworkResponseState.Loading -> {
                        _bendingBuddyHomeUiState.postValue(HomeUiState.Loading)
                    }

                    is NetworkResponseState.Success -> {
                        _bendingBuddyHomeUiState.postValue(
                            HomeUiState.Success(
                                bendingBuddyListMapper.map(it.result)
                            )
                        )
                    }

                }
            }
        }
    }

    fun getBendingBuddyByName(bendingBuddyName: String) {
        viewModelScope.launch {
            getBendingBuddyByNameUseCase(bendingBuddyName).collect {

                when (it) {

                    is NetworkResponseState.Error -> {
                        _bendingBuddyHomeUiState.postValue(
                            HomeUiState.Error(corePresentationRes.string.unknown_error)
                        )
                    }

                    NetworkResponseState.Loading -> {
                        _bendingBuddyHomeUiState.postValue(HomeUiState.Loading)
                    }

                    is NetworkResponseState.Success -> {
                        _bendingBuddyHomeUiState.postValue(
                            HomeUiState.Success(
                                bendingBuddyListMapper.map(it.result)

                            )
                        )
                    }

                }
            }
        }
    }

}