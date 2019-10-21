package com.svmglobal.wrkitdemo.ui.offers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class OffersViewModel : ViewModel() {

    private val _text = MutableLiveData<String>().apply {
        value = "This is the list of offers"
    }
    val text: LiveData<String> = _text
}