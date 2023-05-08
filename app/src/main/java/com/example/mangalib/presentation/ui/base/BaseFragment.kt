package com.example.mangalib.presentation.ui.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.viewbinding.ViewBinding
import com.example.mangalib.domain.utils.UiState
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

abstract class BaseFragment<VB : ViewBinding> : Fragment() {
    lateinit var binding: VB
    abstract fun inflate(layoutInflater: LayoutInflater): VB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initView()
        initListener()
    }

    abstract fun initView()
    abstract fun initListener()

    protected fun <T> StateFlow<UiState<T>>.collectState(
        onLoading: () -> Unit,
        Error: (message: String) -> Unit,
        onSuccess: (data: T) -> Unit
    ) {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                this@collectState.collect { state ->
                    when (state) {
                        is UiState.Loading -> {
                            onLoading()
                        }

                        is UiState.Error -> {
                            Error(state.message)
                        }

                        is UiState.Success -> {
                            onSuccess(state.data)
                        }

                        is UiState.Empty -> {

                        }
                    }

                }
            }

        }
    }
}