package com.whale.bendingbuddies.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.navArgs
import com.whale.bendingbuddies.databinding.FragmentDetailBinding
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

        detailViewModel.getBendingBuddyByName(args.name)

        observeDetailUiState()

    }

    private fun observeDetailUiState() {
        detailViewModel.bendingBuddyDetailUiState.observe(viewLifecycleOwner) {
            when (it) {
                is DetailUiState.Error -> {
                    Toast.makeText(
                        requireContext(),
                        getString(it.message),
                        Toast.LENGTH_LONG
                    ).show()
                }

                DetailUiState.Loading -> {
                    Toast.makeText(
                        requireContext(),
                        "Loading",
                        Toast.LENGTH_LONG
                    ).show()
                }

                is DetailUiState.Success -> {
                    handleSuccessDetailUiState(it.detailUiData)
                }
            }
        }
    }

    private fun handleSuccessDetailUiState(detailUiData: DetailUiData) {
        binding.bendingBuddyDetail.apply {
            setBendingBuddyDetailData(detailUiData)
            setNameTextSize(NAME_TEXT_SIZE_IN_SP)
            setAffiliationTextSize(AFFILIATION_TEXT_SIZE_IN_SP)
        }
    }

    companion object {
        private const val NAME_TEXT_SIZE_IN_SP = 24f
        private const val AFFILIATION_TEXT_SIZE_IN_SP = 18f
    }

}