package com.svmglobal.wrkitdemo.ui.mycards

import androidx.lifecycle.ViewModel
import com.svmglobal.wrkitdemo.models.Card
import com.svmglobal.wrkitdemo.models.Transaction


data class MyCardDetailsViewModel(
    val cardBrand: String,
    val brandImage: String,
    val lastFourDigits: String,
    val expiryDate: String,
    val cardholderName: String,
    val transactions: Array<Transaction>
) : ViewModel() {
    val maskedCardNumber = "xxxx xxxx xxxx ${lastFourDigits}"

    constructor(card: Card) : this(
        card.cardBrand,
        card.brandImage,
        card.lastFourDigits,
        card.expiryDate,
        card.cardholderName,
        card.transactions
    )
}