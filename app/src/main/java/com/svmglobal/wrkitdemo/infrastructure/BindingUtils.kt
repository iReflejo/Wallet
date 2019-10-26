package com.svmglobal.wrkitdemo.infrastructure

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.squareup.picasso.Picasso
import java.text.NumberFormat

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
    if (imageUrl.isNotEmpty()) {
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

@BindingAdapter("bind:currency")
fun displayCurrency(view: TextView, value: Float) {
    if ((value).isNaN()) {
        view.text = ""
        return
    }

    val formatter = NumberFormat.getCurrencyInstance()
    view.text = formatter.format(value)
}

