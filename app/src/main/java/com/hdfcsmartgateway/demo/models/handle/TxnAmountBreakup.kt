package com.hdfcsmartgateway.demo.models.handle

data class TxnAmountBreakup(
    val amount: Int,
    val method: String,
    val name: String,
    val sno: Int
)