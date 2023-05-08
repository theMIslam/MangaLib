package com.example.mangalib.presentation.ui.activity.ui.home

import android.view.LayoutInflater
import android.widget.SearchView
import com.example.mangalib.databinding.FragmentHomeBinding
import com.example.mangalib.presentation.ui.base.BaseFragment
import com.example.mangalib.presentation.ui.fragment.manga.AllMangaViewModel
import com.example.mangalib.utils.ViewPagerAdapter
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class HomeFragment : BaseFragment<FragmentHomeBinding>() {

    private val viewModel: AllMangaViewModel by sharedViewModel()

    override fun inflate(layoutInflater: LayoutInflater): FragmentHomeBinding {
        return FragmentHomeBinding.inflate(layoutInflater)
    }

    override fun initListener() {

        val viewPager = binding.viewPager
        viewPager.adapter = ViewPagerAdapter(parentFragmentManager)

    }


    override fun initView() {
        binding.searchId.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(p0: String): Boolean {

                p0.let {
                    viewModel.getMangaSearch(it)
                }

                return false
            }

            override fun onQueryTextChange(p0: String?): Boolean {

                return false
            }

        })

    }

}
