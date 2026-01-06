package com.hdfcsmartgateway.demo.models.initiate

data class SdkPayload(
    val currTime: String,
    val expiry: String,
    val payload: Payload,
    val requestId: String,
    val service: String
)