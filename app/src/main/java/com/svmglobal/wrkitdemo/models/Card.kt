package com.svmglobal.wrkitdemo.models

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.ViewModel

data class Card(
    val cardBrand: String,
    val brandImage: String,
    val lastFourDigits: String,
    val expiryDate: String?,
    val cardholderName: String?,
    val transactions: Array<Transaction>
) : ViewModel(), Parcelable {
    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString()!!,
        parcel.readString(),
        parcel.readString(),
        parcel.createTypedArray(Transaction)!!
    ) {
    }

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cardBrand)
        parcel.writeString(brandImage)
        parcel.writeString(lastFourDigits)
        parcel.writeString(expiryDate)
        parcel.writeString(cardholderName)
        parcel.writeTypedArray(transactions, flags)
    }

    override fun describeContents(): Int {
        return 0
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Card

        if (cardBrand != other.cardBrand) return false
        if (brandImage != other.brandImage) return false
        if (lastFourDigits != other.lastFourDigits) return false
        if (expiryDate != other.expiryDate) return false
        if (cardholderName != other.cardholderName) return false
        if (!transactions.contentEquals(other.transactions)) return false

        return true
    }

    override fun hashCode(): Int {
        var result = cardBrand.hashCode()
        result = 31 * result + brandImage.hashCode()
        result = 31 * result + lastFourDigits.hashCode()
        result = 31 * result + expiryDate.hashCode()
        result = 31 * result + cardholderName.hashCode()
        result = 31 * result + transactions.contentHashCode()
        return result
    }

    companion object CREATOR : Parcelable.Creator<Card> {
        override fun createFromParcel(parcel: Parcel): Card {
            return Card(parcel)
        }

        override fun newArray(size: Int): Array<Card?> {
            return arrayOfNulls(size)
        }
    }
}

