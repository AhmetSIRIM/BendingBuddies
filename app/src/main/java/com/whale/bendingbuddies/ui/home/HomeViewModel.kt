package com.whale.bendingbuddies.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.whale.bendingbuddies.R
import com.whale.bendingbuddies.data.NetworkResponseState
import com.whale.bendingbuddies.data.mapper.BendingBuddyListMapper
import com.whale.bendingbuddies.domain.BendingBuddyEntity
import com.whale.bendingbuddies.domain.usecase.GetAllBendingBuddiesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllBendingBuddiesUseCase: GetAllBendingBuddiesUseCase,
    private val bendingBuddyListMapper: BendingBuddyListMapper<BendingBuddyEntity, HomeUiData>
) : ViewModel() {

    private val _bendingBuddyHomeUiState = MutableLiveData<HomeUiState>()
    val bendingBuddyHomeUiState: LiveData<HomeUiState> get() = _bendingBuddyHomeUiState

    init {
        getAllBendingBuddies()
    }

    fun getAllBendingBuddies() {
        viewModelScope.launch {
            getAllBendingBuddiesUseCase().collect {
                when (it) {

                    is NetworkResponseState.Error -> {
                        _bendingBuddyHomeUiState.postValue(
                            HomeUiState.Error(R.string.unknown_error)
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