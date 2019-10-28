package com.svmglobal.wrkitdemo.ui.mycards

import android.os.Parcel
import android.os.Parcelable
import androidx.lifecycle.ViewModel
import com.svmglobal.wrkitdemo.services.InternalApiClient


data class AddCardViewModel(
    val cardNumber: String,
    val expiryDate: String?,
    val cardholderName: String?,
    val cvv: String?
) : ViewModel(), Parcelable {
    val maskedCardNumber = "xxxx xxxx xxxx ${cardNumber.substring(cardNumber.length - 4)}"
    val brandImage: String
        get() {
            if (cardNumber.startsWith("44")) {
                return InternalApiClient.visa.logoUrl
            }
            return InternalApiClient.mastercard.logoUrl
        }

    constructor(parcel: Parcel) : this(
        parcel.readString()!!,
        parcel.readString(),
        parcel.readString(),
        parcel.readString()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        parcel.writeString(cardNumber)
        parcel.writeString(expiryDate)
        parcel.writeString(cardholderName)
        parcel.writeString(cvv)
    }

    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<AddCardViewModel> {
        override fun createFromParcel(parcel: Parcel): AddCardViewModel {
            return AddCardViewModel(parcel)
        }

        override fun newArray(size: Int): Array<AddCardViewModel?> {
            return arrayOfNulls(size)
        }
    }

}