package com.example.mangalib.domain.model.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions
import com.example.mangalib.R

fun urlToImage(view: ImageView, string: String) {
    val opinions = RequestOptions.placeholderOf(R.drawable.ic_loading).error(R.drawable.ic_error)
    Glide.with(view).setDefaultRequestOptions(opinions).load(string).into(view)
}