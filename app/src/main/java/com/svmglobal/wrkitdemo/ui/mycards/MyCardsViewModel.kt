package com.svmglobal.wrkitdemo.ui.mycards

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.svmglobal.wrkitdemo.models.Card

class MyCardsViewModel : ViewModel() {
    val selected = MutableLiveData<Card>()

    fun select(card: Card) {
        selected.value = card
    }
}