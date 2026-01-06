package com.hdfcsmartgateway.demo.models.handle

data class Card(
    val card_brand: String,
    val card_fingerprint: String,
    val card_isin: String,
    val card_issuer: String,
    val card_issuer_country: String,
    val card_reference: String,
    val card_type: String,
    val expiry_month: String,
    val expiry_year: String,
    val extended_card_type: String,
    val juspay_bank_code: String,
    val last_four_digits: String,
    val name_on_card: String,
    val payment_account_reference: String,
    val saved_to_locker: Boolean,
    val token_type: String,
    val tokens: List<Any>,
    val using_saved_card: Boolean,
    val using_token: Boolean
)