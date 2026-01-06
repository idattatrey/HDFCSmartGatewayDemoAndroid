package com.hdfcsmartgateway.demo.models.handle

data class TxnDetail(
    val created: String,
    val currency: String,
    val error_code: Any,
    val error_message: String,
    val express_checkout: Boolean,
    val gateway: String,
    val gateway_id: Int,
    val is_cvv_less_txn: Boolean,
    val last_updated: String,
    val metadata: Metadata,
    val net_amount: Int,
    val offer_deduction_amount: Any,
    val order_id: String,
    val redirect: Boolean,
    val status: String,
    val surcharge_amount: Any,
    val tax_amount: Any,
    val txn_amount: Int,
    val txn_amount_breakup: List<TxnAmountBreakup>,
    val txn_flow_type: String,
    val txn_id: String,
    val txn_uuid: String
)