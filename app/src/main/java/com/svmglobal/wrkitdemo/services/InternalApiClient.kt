package com.svmglobal.wrkitdemo.services

import com.svmglobal.wrkitdemo.models.Card
import com.svmglobal.wrkitdemo.models.Offer
import com.svmglobal.wrkitdemo.models.PaymentMethod
import com.svmglobal.wrkitdemo.models.Transaction

object InternalApiClient {
    private val visa =
        PaymentMethod("VISA", "https://svmvirtodemo.blob.core.windows.net/wrkit-demo/visa.png")
    private val mastercard = PaymentMethod(
        "Mastercard",
        "https://svmvirtodemo.blob.core.windows.net/wrkit-demo/mastercard.png"
    )
    private val googlePay = PaymentMethod(
        "Google Pay",
        "https://svmvirtodemo.blob.core.windows.net/wrkit-demo/google-pay.png"
    )

    fun getAllOffers(): Array<Offer> {

        return arrayOf(
            Offer(
                "Tesco",
                "https://upload.wikimedia.org/wikipedia/en/thumb/b/b0/Tesco_Logo.svg/800px-Tesco_Logo.svg.png",
                "https://svmvirtodemo.blob.core.windows.net/wrkit-demo/tesco_store.jpg",
                "Save 3% on all in-store purchases",
                "Save 3% on all in-store purchases when you shop between now and christmas",
                0.5f,
                instoreUse = true,
                onlineUse = true,
                paymentMethods = arrayOf(visa, mastercard, googlePay)
            ),
            Offer(
                "Starbucks",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQiOvW7N7HpJ6vnZs8vG8aR3jRGTCa4FC6OZ5IR1m_kHvksK7L0",
                "https://svmvirtodemo.blob.core.windows.net/wrkit-demo/starbucks_banner.jpg",
                "Get 10% cashback on all purchases from our limited time Halloween products",
                "Get 10% cashback on all purchases from our limited time Halloween products",
                0.8f,
                instoreUse = true,
                onlineUse = false,
                paymentMethods = arrayOf(mastercard, googlePay)
            ),
            Offer(
                "McDonalds",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVy23UkzGE13e9FSSBitLm8vPzaUXco9zNMUeTvVXZb9BrJ8fl",
                "https://svmvirtodemo.blob.core.windows.net/wrkit-demo/mcdonalds_banner.jpg",
                "5% cashback on all purchases",
                "5% cashback on all purchases",
                1.2f,
                instoreUse = true,
                onlineUse = false,
                paymentMethods = arrayOf(visa)
            )
        )
    }

    fun getAllCards(): Array<Card> {
        return arrayOf(
            Card(
                "VISA Credit",
                visa.logoUrl,
                "5368",
                "05/21",
                "John Smith",
                arrayOf(
                    Transaction("Tesco", "07:35", 23.99f, 0.72f, 3f, "Pending"),
                    Transaction("Amazon", "Yesterday", 8.99f, 0f, 0f, ""),
                    Transaction("McDonalds", "23/10", 10.48f, 1.05f, 10f, "Complete")
                )
            ),
            Card(
                "Mastercard Credit",
                mastercard.logoUrl,
                "3522",
                "02/22",
                "John Smith",
                arrayOf()
            ),
            Card(
                "VISA Debit",
                visa.logoUrl,
                "4257",
                "08/20",
                "John Smith",
                arrayOf()
            )
        )
    }
}