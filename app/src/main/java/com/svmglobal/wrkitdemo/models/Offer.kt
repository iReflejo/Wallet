package com.svmglobal.wrkitdemo.models

import androidx.lifecycle.ViewModel
import java.io.Serializable


data class Offer(
    val brand: String,
    val brandImage: String,
    val brandBannerImage: String,
    val promotionShortDescription: String,
    val promotionLongDescription: String,
    val distance: Float,
    val instoreUse: Boolean,
    val onlineUse: Boolean
) : Serializable, ViewModel()