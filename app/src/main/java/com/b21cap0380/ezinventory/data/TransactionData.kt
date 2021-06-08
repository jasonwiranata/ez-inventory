package com.b21cap0380.ezinventorymanagement.data

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class TransactionData(
    var transactionId: String? = "",
    var transactionDate: String? = "",
    var productId: String? = null,
    var productName: String? = null,
    var productSold: Int = 0,
    var productUnit: String? = null,
)
