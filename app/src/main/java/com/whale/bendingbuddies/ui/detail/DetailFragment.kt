package com.whale.bendingbuddies.ui.detail

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.whale.bendingbuddies.databinding.FragmentDetailBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DetailFragment : Fragment() {

    private lateinit var binding: FragmentDetailBinding
    private val detailViewModel by viewModels<DetailViewModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentDetailBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
        binding.bendingBuddyDetail.setBendingBuddyDetailData(detailUiData)
    }

}