package com.hdfcsmartgateway.demo.models.initiate

data class Payload(
    val action: String,
    val amount: String,
    val clientAuthToken: String,
    val clientAuthTokenExpiry: String,
    val clientId: String,
    val collectAvsInfo: Boolean,
    val currency: String,
    val displayBusinessAs: String,
    val environment: String,
    val merchantId: String,
    val orderId: String,
    val service: String
)