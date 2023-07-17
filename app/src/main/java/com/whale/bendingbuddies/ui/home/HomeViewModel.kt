package com.whale.bendingbuddies.ui.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.whale.bendingbuddies.R
import com.whale.bendingbuddies.data.NetworkResponseState
import com.whale.bendingbuddies.data.mapper.BendingBuddyListMapper
import com.whale.bendingbuddies.domain.entity.BendingBuddyEntity
import com.whale.bendingbuddies.domain.usecase.GetAllBendingBuddiesUseCase
import com.whale.bendingbuddies.domain.usecase.GetBendingBuddyByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllBendingBuddiesUseCase: GetAllBendingBuddiesUseCase,
    private val getBendingBuddyByNameUseCase: GetBendingBuddyByNameUseCase,
    private val bendingBuddyListMapper: BendingBuddyListMapper<BendingBuddyEntity, HomeUiData>
) : ViewModel() {

    private val _bendingBuddyHomeUiState = MutableLiveData<HomeUiState>()
    val bendingBuddyHomeUiState: LiveData<HomeUiState> get() = _bendingBuddyHomeUiState

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

    fun getBendingBuddyByName(bendingBuddyName: String) {
        viewModelScope.launch {
            getBendingBuddyByNameUseCase(bendingBuddyName).collect {

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