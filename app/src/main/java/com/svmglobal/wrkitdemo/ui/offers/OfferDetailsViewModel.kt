package com.svmglobal.wrkitdemo.ui.offers

import androidx.lifecycle.ViewModel
import com.svmglobal.wrkitdemo.models.Offer


data class OfferDetailsViewModel(
    val brand: String,
    val brandImage: String,
    val brandBannerImage: String,
    val promotionShortDescription: String,
    val promotionLongDescription: String,
    val distance: Float,
    val instoreUse: Boolean,
    val onlineUse: Boolean
) : ViewModel() {

    val availability: String
        get() {
            var s = if (onlineUse) "Online" else ""

            if (!instoreUse) {
                return s
            }

            if (s.isNotEmpty()) {
                s += " / "
            }
            s += "In Store"
            return s
        }

    constructor(offer: Offer) : this(
        offer.brand,
        offer.brandImage,
        offer.brandBannerImage,
        offer.promotionShortDescription,
        offer.promotionLongDescription,
        offer.distance,
        offer.instoreUse,
        offer.onlineUse
    )
}