package com.example.mangalib.presentation.ui.fragment.open

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.widget.Toast
import com.example.mangalib.databinding.FragmentOpenBinding
import com.example.mangalib.presentation.ui.base.BaseFragment
import org.koin.androidx.viewmodel.ext.android.viewModel


class OpenFragment : BaseFragment<FragmentOpenBinding>() {
    private val viewModel: OpenViewModel by viewModel()
    lateinit var adapter: OpenAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = OpenAdapter()
    }

    override fun inflate(layoutInflater: LayoutInflater): FragmentOpenBinding {
        return FragmentOpenBinding.inflate(layoutInflater)
    }

    override fun initView() {
        val result = arguments?.getInt("key")
        if (result != null) {
            viewModel.getAllMangaId(result)
        }

    }

    override fun initListener() {
        viewModel.getAllMangaId.collectState({}, {
        }, {
            binding.recycle.adapter = adapter
            adapter.array(it)
            Log.e("ololo", "result:${it} ")
            Toast.makeText(requireContext(), "id${it}", Toast.LENGTH_SHORT).show()

        })
    }


}