package com.example.mangalib.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.example.mangalib.presentation.ui.fragment.manga.AllMangaFragment
import com.example.mangalib.presentation.ui.fragment.topmanga.MangaFragment

class ViewPagerAdapter(fm: FragmentManager) : FragmentPagerAdapter(fm) {
    private val COUNT = 2

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> AllMangaFragment()
            1 -> MangaFragment()
            else -> AllMangaFragment()
        }
    }

    override fun getCount(): Int {
        return COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return "Tab " + (position + 1)
    }

}