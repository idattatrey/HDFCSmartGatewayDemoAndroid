package com.hdfcsmartgateway.demo.models.handle

data class PaymentGatewayResponse(
    val arn: Any,
    val auth_id_code: Any,
    val auth_ref_num: Any,
    val created: String,
    val current_blocked_amount: Any,
    val cvv_check: Any,
    val eci: Any,
    val epg_txn_id: String,
    val gateway_merchant_id: Any,
    val network_error_code: Any,
    val network_error_message: Any,
    val payer_ifsc: Any,
    val resp_code: Any,
    val resp_message: Any,
    val rrn: String,
    val txn_id: Any,
    val umrn: Any,
    val xid: Any
)