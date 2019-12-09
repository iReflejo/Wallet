package com.svmglobal.wrkitdemo.services

import com.svmglobal.wrkitdemo.models.Card
import com.svmglobal.wrkitdemo.models.Offer
import com.svmglobal.wrkitdemo.models.PaymentMethod
import com.svmglobal.wrkitdemo.models.Transaction

object InternalApiClient {
    val visa =
        PaymentMethod("VISA", "https://svmvirtodemo.blob.core.windows.net/wrkit-demo/visa.png")
    val mastercard = PaymentMethod(
        "Mastercard",
        "https://svmvirtodemo.blob.core.windows.net/wrkit-demo/mastercard.png"
    )
    val googlePay = PaymentMethod(
        "Google Pay",
        "https://svmvirtodemo.blob.core.windows.net/wrkit-demo/google-pay.png"
    )

    fun getAllOffers(): Array<Offer> {

        return arrayOf(
            Offer(
                "Circle K",
                "https://www.circlek.com/themes/custom/circlek/images/logos/logo_circlek_wide.png",
                "https://www.circlek.ie/wp-content/uploads/2018/04/banner_service_station.jpg",
                "Get 3% cashback on all purchases*",
                "Get 3% cashback on all purchases. Excludes tobacco, alcohol, lottery, money order and gift cards.",
                0.8f,
                instoreUse = true,
                onlineUse = false,
                paymentMethods = arrayOf(mastercard, googlePay)
            ),
            Offer(
                "Circle K",
                "https://www.circlek.com/themes/custom/circlek/images/logos/logo_circlek_wide.png",
                "https://www.circlek.ie/wp-content/uploads/2018/04/banner_service_station.jpg",
                "Save 20% on your first car wash at Circle K",
                "Save 20% on your first car wash at Circle K",
                0.5f,
                instoreUse = true,
                onlineUse = false,
                paymentMethods = arrayOf(visa, mastercard, googlePay)
            ),
            Offer(
                "Circle K",
                "https://www.circlek.com/themes/custom/circlek/images/logos/logo_circlek_wide.png",
                "https://www.circlek.ie/wp-content/uploads/2018/04/banner_service_station.jpg",
                "Get an additional 4% back on all purchases at Circle K Express Ushers Quay*",
                "Get an additional 4% back on all purchases at Circle K Express Ushers Quay. Excludes tobacco, alcohol, lottery, money order and gift cards.",
                1.9f,
                instoreUse = true,
                onlineUse = false,
                paymentMethods = arrayOf(mastercard, googlePay)
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