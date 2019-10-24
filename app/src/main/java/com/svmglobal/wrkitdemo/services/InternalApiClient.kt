package com.svmglobal.wrkitdemo.services

import com.svmglobal.wrkitdemo.models.Card
import com.svmglobal.wrkitdemo.models.Offer
import com.svmglobal.wrkitdemo.models.PaymentMethod

object InternalApiClient {
    fun getAllOffers(): Array<Offer> {

        val paymentMethods = arrayOf(
            PaymentMethod(
                "All",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQB_a30TT37soT-2Z6Sl3uy4Bk22vrpfhpdaOpJ212kq9A9U-fuYQ&s"
            )
        )

        return arrayOf(
            Offer(
                "Tesco",
                "https://upload.wikimedia.org/wikipedia/en/thumb/b/b0/Tesco_Logo.svg/800px-Tesco_Logo.svg.png",
                "https://mobilemarketingmagazine.com/wp-content/uploads/Tesco_store_again.jpg",
                "Save 3% on all in-store purchases",
                "Save 3% on all in-store purchases when you shop between now and christmas",
                0.5f,
                instoreUse = true,
                onlineUse = true,
                paymentMethods = paymentMethods
            ),
            Offer(
                "Starbucks",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcQiOvW7N7HpJ6vnZs8vG8aR3jRGTCa4FC6OZ5IR1m_kHvksK7L0",
                "",
                "Get 10% cashback on all purchases from our limited time Halloween products",
                "",
                0.8f,
                instoreUse = true,
                onlineUse = false,
                paymentMethods = paymentMethods
            ),
            Offer(
                "McDonalds",
                "https://encrypted-tbn0.gstatic.com/images?q=tbn:ANd9GcTVy23UkzGE13e9FSSBitLm8vPzaUXco9zNMUeTvVXZb9BrJ8fl",
                "",
                "5% cashback on all purchases",
                "",
                1.2f,
                instoreUse = true,
                onlineUse = false,
                paymentMethods = paymentMethods
            )
        )
    }

    fun getAllCards(): Array<Card> {
        return arrayOf(
            Card(
                "VISA Credit",
                "https://svmvirtodemo.blob.core.windows.net/wrkit-demo/visa.png",
                "5368",
                "05/21"
            ),
            Card(
                "Mastercard Credit",
                "https://svmvirtodemo.blob.core.windows.net/wrkit-demo/mastercard.png",
                "3522",
                "02/22"
            ),
            Card(
                "VISA Debit",
                "https://svmvirtodemo.blob.core.windows.net/wrkit-demo/visa.png",
                "4257",
                "08/20"
            )
        )
    }
}