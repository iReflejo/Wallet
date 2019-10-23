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
    if(!imageUrl.isNullOrEmpty()) {
        Picasso
            .get()
            .load(imageUrl)
            .into(view)
    }
}

@BindingAdapter("bind:distance")
fun formatString(view: TextView, distance: Float) {
    if ((distance).isNaN()) {
        view.text = ""
        return
    }
    view.text = "$distance km"
}