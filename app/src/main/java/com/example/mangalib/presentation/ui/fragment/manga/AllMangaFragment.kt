package com.example.mangalib.presentation.ui.fragment.manga

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import androidx.lifecycle.coroutineScope
import androidx.navigation.fragment.findNavController
import com.example.mangalib.R
import com.example.mangalib.databinding.FragmentAllMangaBinding
import com.example.mangalib.presentation.ui.base.BaseFragment
import com.example.mangalib.presentation.ui.fragment.MangaAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class AllMangaFragment : BaseFragment<FragmentAllMangaBinding>() {
    private val viewModel: AllMangaViewModel by sharedViewModel()
    lateinit var adapter: MangaAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        adapter = MangaAdapter()

    }

    override fun inflate(layoutInflater: LayoutInflater): FragmentAllMangaBinding {
        return FragmentAllMangaBinding.inflate(layoutInflater)
    }


    override fun initListener() {

        lifecycle.coroutineScope.launchWhenCreated {

            viewModel.getAllManga.collectState(
                onLoading = {
                    binding.progress.visibility = View.VISIBLE
                },
                Error = {
                    binding.progress.visibility = View.GONE

                },
                onSuccess = {
                    binding.progress.visibility = View.GONE

                    binding.recycle.adapter = adapter
                    adapter.array(it)
                })
        }
        lifecycle.coroutineScope.launchWhenCreated {
            viewModel.getMangaSearch.collectState({
                binding.progress.visibility = View.VISIBLE
                binding.tvSearchError.visibility = View.GONE

            }, {
                binding.tvSearchError.visibility = View.VISIBLE
                binding.tvSearchError.text = it
            }, {
                binding.progress.visibility = View.GONE
                binding.tvSearchError.visibility = View.INVISIBLE
                binding.recycle.adapter = adapter
                adapter.setContentList(it.toMutableList())
            })
        }
    }

    override fun initView() {
        adapter.onClick = {
            val bundle = Bundle()
            bundle.putInt("key", it.id)
            Log.e("ololo", "initView:${it} ")
            findNavController().navigate(R.id.openFragment, bundle)
        }

    }
}