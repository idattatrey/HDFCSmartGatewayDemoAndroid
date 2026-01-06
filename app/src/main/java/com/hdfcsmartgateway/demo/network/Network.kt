package com.hdfcsmartgateway.demo.network

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class Network {
    companion object{
        val retrofit: Retrofit = Retrofit.Builder()
            .baseUrl("http://10.0.2.2:5000/")
            .addConverterFactory(
                GsonConverterFactory.create()
            ).build()

        val service: ApiService = retrofit.create(ApiService::class.java)
    }
}