package com.svmglobal.wrkitdemo.models

import androidx.lifecycle.ViewModel

data class Transaction(
    val storeName: String,
    val transactionDate: String,
    val amount: Float,
    val cashbackAmount: Float,
    val cashbackPercent: Float,
    val cashbackStatus: String
) : ViewModel()