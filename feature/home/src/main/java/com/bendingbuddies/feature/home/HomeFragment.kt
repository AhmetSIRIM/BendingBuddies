package com.bendingbuddies.feature.home

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import androidx.annotation.StringRes
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import com.bendingbuddies.core.presentation.model.home.HomeUiData
import com.bendingbuddies.core.presentation.model.home.HomeUiState
import com.bendingbuddies.core.presentation.utility.isLengthGreaterOrEqualTo
import com.bendingbuddies.core.presentation.utility.observeTextChanges
import com.bendingbuddies.feature.home.adapter.BendingBuddyRecyclerViewAdapter
import com.bendingbuddies.feature.home.databinding.FragmentHomeBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import androidx.navigation.fragment.findNavController
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

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

        observeSearchTextChanges()

        initBendingBuddyRecyclerViewAdapter()

        observeHomeUiState()

    }

    private fun initBendingBuddyRecyclerViewAdapter() {
        adapter.setOnItemClickListener {
            val homeUiData = adapter.getItem(it)
            val action =
                HomeFragmentDirections.actionHomeFragmentToDetailFragment(homeUiData.name)
            findNavController().navigate(action)
        }
        binding.bendingBuddyListRecyclerView.adapter = adapter
    }

    private fun observeHomeUiState() {
        homeViewModel.bendingBuddyHomeUiState.observe(viewLifecycleOwner) {
            when (it) {

                is HomeUiState.Error -> handleErrorHomeUiState(
                    it.message
                )

                HomeUiState.Loading -> handleLoadingHomeUiState()

                is HomeUiState.Success -> handleSuccessHomeUiState(
                    it.homeUiDataList
                )

            }
        }
    }

    private fun handleErrorHomeUiState(
        @StringRes
        stringRes: Int
    ) {
        Toast.makeText(requireContext(), stringRes, LENGTH_LONG).show()
    }

    private fun handleLoadingHomeUiState() {
        binding.apply {
            bendingBuddyListRecyclerView.isVisible = false
            animationViewHomeLoading.isVisible = true
        }
    }

    private fun handleSuccessHomeUiState(homeUiDataList: List<HomeUiData>) {
        adapter.updateHomeUiDataList(homeUiDataList)
        binding.apply {
            bendingBuddyListRecyclerView.isVisible = true
            animationViewHomeLoading.isVisible = false
        }
    }

    @OptIn(FlowPreview::class)
    private fun observeSearchTextChanges() {
        binding.searchEditText.observeTextChanges()
            .debounce(SEARCH_DEBOUNCE_TIME_IN_MILLISECONDS)
            .distinctUntilChanged()
            .onEach { inputText ->
                when {
                    (inputText.isBlank() && adapter.itemCount < MAXIMUM_RESPONSE_LIST_LENGTH_FOR_REQUEST_WITH_SPECIFIC_NAME_INPUT) -> {
                        homeViewModel.getAllBendingBuddies()
                        hideKeyboard()
                    }

                    (inputText isLengthGreaterOrEqualTo MINIMUM_SEARCH_LENGTH && adapter.itemCount > MAXIMUM_RESPONSE_LIST_LENGTH_FOR_REQUEST_WITH_SPECIFIC_NAME_INPUT) -> {
                        homeViewModel.getBendingBuddyByName(inputText)
                        hideKeyboard()
                    }
                }
            }.launchIn(lifecycleScope)
    }

    private fun hideKeyboard() {
        val inputMethodManager =
            requireActivity().getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        inputMethodManager?.hideSoftInputFromWindow(requireView().windowToken, 0)
    }

    companion object {
        private const val MINIMUM_SEARCH_LENGTH = 2

        private const val SEARCH_DEBOUNCE_TIME_IN_MILLISECONDS = 300L

        // TODO (Ahmet) ---> The line below is based on an assumption, if I find a better approach I will implement it.
        private const val MAXIMUM_RESPONSE_LIST_LENGTH_FOR_REQUEST_WITH_SPECIFIC_NAME_INPUT = 20
    }

}


