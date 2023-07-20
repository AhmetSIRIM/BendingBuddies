package com.bendingbuddies.feature.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.annotation.StringRes
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.bendingbuddies.core.presentation.model.detail.DetailUiData
import com.bendingbuddies.core.presentation.model.detail.DetailUiState
import com.bendingbuddies.core.presentation.utility.trimWhitespaceAfterSpace
import com.bendingbuddies.feature.detail.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val detailViewModel by viewModels<DetailViewModel>()
    private val args: DetailFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        detailViewModel.getBendingBuddyByName(args.name.trimWhitespaceAfterSpace())

        observeDetailUiState()

    }

    private fun observeDetailUiState() {
        detailViewModel.bendingBuddyDetailUiState.observe(viewLifecycleOwner) {
            when (it) {

                is DetailUiState.Error -> handleErrorDetailUiState(it.message)

                DetailUiState.Loading -> handleLoadingDetailUiState()

                is DetailUiState.Success -> handleSuccessDetailUiState(it.detailUiData)

            }
        }
    }

    private fun handleErrorDetailUiState(
        @StringRes
        stringRes: Int
    ) {
        Toast.makeText(requireContext(), stringRes, LENGTH_LONG).show()
    }

    private fun handleLoadingDetailUiState() {
        binding.apply {
            bendingBuddyDetail.isVisible = false
            animationViewDetailLoading.isVisible = true
        }
    }

    private fun handleSuccessDetailUiState(detailUiData: DetailUiData) {

        binding.apply {

            bendingBuddyDetail.apply {
                setBendingBuddyDetailData(detailUiData)
                setNameTextSize(NAME_TEXT_SIZE_IN_SP)
                setAffiliationTextSize(AFFILIATION_TEXT_SIZE_IN_SP)
            }

            bendingBuddyDetail.isVisible = true
            animationViewDetailLoading.isVisible = false
        }
    }

    companion object {
        private const val NAME_TEXT_SIZE_IN_SP = 24f
        private const val AFFILIATION_TEXT_SIZE_IN_SP = 18f
    }

}