package com.example.mangalib.presentation.ui.fragment.splash

import android.os.Handler
import android.os.Looper
import android.view.LayoutInflater
import androidx.navigation.fragment.findNavController
import com.example.mangalib.R
import com.example.mangalib.databinding.FragmentSplashBinding
import com.example.mangalib.presentation.ui.base.BaseFragment
import com.example.mangalib.presentation.ui.fragment.manga.AllMangaViewModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SplashFragment : BaseFragment<FragmentSplashBinding>() {
    private val viewModel: AllMangaViewModel by sharedViewModel()

    override fun inflate(layoutInflater: LayoutInflater): FragmentSplashBinding {
        return FragmentSplashBinding.inflate(layoutInflater)
    }

    override fun initView() {
        viewModel.getAllManga()

        Handler(Looper.getMainLooper()).postDelayed({
            findNavController().navigate(R.id.action_splashFragment_to_navigation_home)
        }, 1500)
    }

    override fun initListener() {
    }

}
