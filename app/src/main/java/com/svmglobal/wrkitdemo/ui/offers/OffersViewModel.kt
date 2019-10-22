package com.svmglobal.wrkitdemo.ui.offers

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.svmglobal.wrkitdemo.models.Offer

class OffersViewModel : ViewModel() {
    val selected = MutableLiveData<Offer>()

    fun select(offer: Offer) {
        selected.value = offer
    }
}