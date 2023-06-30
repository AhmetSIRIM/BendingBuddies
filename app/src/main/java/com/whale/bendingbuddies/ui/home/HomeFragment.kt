package com.whale.bendingbuddies.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.whale.bendingbuddies.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HomeFragment : Fragment() {

    private lateinit var binding: FragmentHomeBinding
    private val homeViewModel by viewModels<HomeViewModel>()
    private val adapter = BendingBuddyRecyclerViewAdapter()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentHomeBinding.inflate(layoutInflater)
        binding.bendingBuddyListRecyclerView.adapter = this.adapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        observeUiState()
    }

    private fun observeUiState() {
        homeViewModel.bendingBuddyHomeUiState.observe(viewLifecycleOwner) {
            when (it) {
                is HomeUiState.Error -> {
                    Toast.makeText(
                        requireContext(),
                        getString(it.message),
                        Toast.LENGTH_LONG
                    ).show()
                }

                HomeUiState.Loading -> {
                    Toast.makeText(
                        requireContext(),
                        "Loading",
                        Toast.LENGTH_LONG
                    ).show()
                }

                is HomeUiState.Success -> {
                    handleSuccessUiState(it.data)
                }
            }
        }
    }

    private fun handleSuccessUiState(data: List<HomeUiData>) {
        adapter.updateHomeUiDataList(data)
    }

}