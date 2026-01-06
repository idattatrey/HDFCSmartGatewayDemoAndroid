package com.hdfcsmartgateway.demo.network

import com.hdfcsmartgateway.demo.models.handle.HandleResponse
import com.hdfcsmartgateway.demo.models.handle_request.HandleRequestBody
import com.hdfcsmartgateway.demo.models.initiate.InitiateResponse
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface ApiService {
    @POST("/initiateJuspayPayment")
    fun getPaymentInfo(): Call<InitiateResponse>

    @POST("/handleJuspayResponse")
    fun handlePayment(@Body handleRequestBody: HandleRequestBody): Call<HandleResponse>
}