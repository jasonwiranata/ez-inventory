package com.b21cap0380.ezinventory.data

import com.google.firebase.database.IgnoreExtraProperties

@IgnoreExtraProperties
data class InventoryData(
    var productId: String? = null,
    var productName: String? = null,
    var productQty: Int = 0,
    var productUnit: String? = null,
)
