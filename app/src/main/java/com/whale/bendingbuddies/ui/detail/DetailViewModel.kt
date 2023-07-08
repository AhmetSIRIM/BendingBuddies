package com.whale.bendingbuddies.ui.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.whale.bendingbuddies.R
import com.whale.bendingbuddies.data.NetworkResponseState
import com.whale.bendingbuddies.data.mapper.BendingBuddyMapper
import com.whale.bendingbuddies.domain.BendingBuddyEntity
import com.whale.bendingbuddies.domain.usecase.GetBendingBuddyByNameUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getBendingBuddyByNameUseCase: GetBendingBuddyByNameUseCase,
    private val bendingBuddyMapper: BendingBuddyMapper<BendingBuddyEntity, DetailUiData>
) : ViewModel() {

    private val _bendingBuddyDetailUiState = MutableLiveData<DetailUiState>()
    val bendingBuddyDetailUiState: LiveData<DetailUiState> get() = _bendingBuddyDetailUiState

    fun getBendingBuddyByName(bendingBuddyName: String) {
        viewModelScope.launch {
            getBendingBuddyByNameUseCase(bendingBuddyName).collect {
                when (it) {

                    is NetworkResponseState.Error -> {
                        _bendingBuddyDetailUiState.postValue(
                            DetailUiState.Error(R.string.unknown_error)
                        )
                    }

                    NetworkResponseState.Loading -> {
                        _bendingBuddyDetailUiState.postValue(DetailUiState.Loading)
                    }

                    is NetworkResponseState.Success -> {
                        _bendingBuddyDetailUiState.postValue(
                            DetailUiState.Success(
                                bendingBuddyMapper.map(it.result?.first())
                            )
                        )
                    }
                }
            }
        }
    }

}