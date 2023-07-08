package com.whale.bendingbuddies.ui.home

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isVisible
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import com.whale.bendingbuddies.databinding.FragmentHomeBinding
import com.whale.bendingbuddies.utility.observeTextChanges
import com.whale.bendingbuddies.utility.okWith
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.flow.filter
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

        homeViewModel.getAllBendingBuddies()

        initPokeListAdapter()

        observeSearchTextChanges()

        observeHomeUiState()

    }

    private fun initPokeListAdapter() {
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
                is HomeUiState.Error -> {
                    Toast.makeText(
                        requireContext(),
                        getString(it.message),
                        Toast.LENGTH_LONG
                    ).show()
                }

                HomeUiState.Loading -> {
                    binding.loadingProgressBar.isVisible = true
                }

                is HomeUiState.Success -> {
                    handleSuccessHomeUiState(it.homeUiDataList)
                    binding.loadingProgressBar.isVisible = false
                }
            }
        }
    }

    private fun handleSuccessHomeUiState(homeUiDataList: List<HomeUiData>) {
        adapter.updateHomeUiDataList(homeUiDataList)
    }

    @OptIn(FlowPreview::class)
    private fun observeSearchTextChanges() {
        binding.searchEditText.observeTextChanges()
            .filter { it okWith MINIMUM_SEARCH_LENGTH }
            .debounce(SEARCH_DEBOUNCE_TIME_IN_MILLISECONDS)
            .distinctUntilChanged()
            .onEach { homeViewModel.getBendingBuddyByName(it) }
            .launchIn(lifecycleScope)
    }

    companion object {
        private const val MINIMUM_SEARCH_LENGTH = 2
        private const val SEARCH_DEBOUNCE_TIME_IN_MILLISECONDS = 300L
    }

}


