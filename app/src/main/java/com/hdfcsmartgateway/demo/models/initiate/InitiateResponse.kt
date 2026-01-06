package com.hdfcsmartgateway.demo.models.initiate

data class InitiateResponse(
    val id: String,
    val order_expiry: String,
    val order_id: String,
    val payment_links: PaymentLinks,
    val sdk_payload: SdkPayload,
    val status: String
)