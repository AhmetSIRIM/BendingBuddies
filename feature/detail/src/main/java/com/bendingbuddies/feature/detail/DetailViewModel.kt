package com.bendingbuddies.feature.detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.bendingbuddies.core.common.NetworkResponseState
import com.bendingbuddies.core.domain.usecase.GetBendingBuddyByNameUseCase
import com.bendingbuddies.core.presentation.model.detail.DetailUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject
import com.bendingbuddies.core.presentation.R as corePresentationRes

@HiltViewModel
class DetailViewModel @Inject constructor(
    private val getBendingBuddyByNameUseCase: GetBendingBuddyByNameUseCase,
    private val bendingBuddyMapper: BendingBuddyDetailUiMapperImpl
) : ViewModel() {

    private val _bendingBuddyDetailUiState = MutableLiveData<DetailUiState>()
    val bendingBuddyDetailUiState: LiveData<DetailUiState> get() = _bendingBuddyDetailUiState

    fun getBendingBuddyByName(bendingBuddyName: String) {
        viewModelScope.launch {
            getBendingBuddyByNameUseCase(bendingBuddyName).collect {
                when (it) {

                    is NetworkResponseState.Error -> {
                        _bendingBuddyDetailUiState.postValue(
                            DetailUiState.Error(corePresentationRes.string.unknown_error)
                        )
                    }

                    NetworkResponseState.Loading -> {
                        _bendingBuddyDetailUiState.postValue(DetailUiState.Loading)
                    }

                    is NetworkResponseState.Success -> {
                        _bendingBuddyDetailUiState.postValue(
                            DetailUiState.Success(
                                bendingBuddyMapper.map(it.result.first())
                            )
                        )
                    }

                }
            }
        }
    }

}