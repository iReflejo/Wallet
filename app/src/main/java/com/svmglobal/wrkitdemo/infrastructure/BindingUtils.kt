package com.svmglobal.wrkitdemo.infrastructure

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso

@BindingAdapter("android:text")
fun setFloat(view: TextView, value: Float) {
    if ((value).isNaN()) {
        view.text = ""
        return
    }

    view.text = value.toString()
}

@BindingAdapter("bind:imageUrl")
fun loadImage(view: ImageView, imageUrl: String) {
    Picasso
        .get()
        .load(imageUrl)
        .into(view)
}