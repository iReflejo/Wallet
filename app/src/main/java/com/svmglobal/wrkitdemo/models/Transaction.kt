package com.svmglobal.wrkitdemo.models

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.ViewModel

data class Transaction(
    val storeName: String,
    val transactionDate: String,
    val amount: Float,
    val cashbackAmount: Float,
    val cashbackPercent: Float,
    val cashbackStatus: String
) : ViewModel(), Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readFloat(),
        parcel.readString()!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(storeName)
        parcel.writeString(transactionDate)
        parcel.writeFloat(amount)
        parcel.writeFloat(cashbackAmount)
        parcel.writeFloat(cashbackPercent)
        parcel.writeString(cashbackStatus)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Transaction> {
        override fun createFromParcel(parcel: Parcel): Transaction {
            return Transaction(parcel)
        }

        override fun newArray(size: Int): Array<Transaction?> {
            return arrayOfNulls(size)
        }
    }
}