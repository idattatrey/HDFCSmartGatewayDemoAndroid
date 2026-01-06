package com.hdfcsmartgateway.demo.models.handle

data class EmiDetails(
    val additional_processing_fee_info: Any,
    val bank: Any,
    val conversion_details: Any,
    val emi_type: Any,
    val interest: Any,
    val monthly_payment: Any,
    val principal_amount: Any,
    val processed_by: Any,
    val subvention_amount: Any,
    val subvention_info: List<Any>,
    val tenure: Any
)