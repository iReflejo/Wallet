package com.svmglobal.wrkitdemo.models

import androidx.lifecycle.ViewModel

data class Card(
    val cardBrand: String,
    val brandImage: String,
    val lastFourDigits: String,
    val expiryDate: String,
    val transactions: Array<Transaction>
) : ViewModel()

