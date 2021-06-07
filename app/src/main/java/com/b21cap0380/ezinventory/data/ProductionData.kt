package com.b21cap0380.ezinventorymanagement.data

import com.google.firebase.database.Exclude
import com.google.firebase.database.IgnoreExtraProperties
import java.util.*

@IgnoreExtraProperties
data class ProductionData(
    var productionId: String? = "",
    var productionDate: String? = "",
    var materialName: String? = "",
    var materialUsed: Int = 0,
    var materialUnit: String? = "",
)
