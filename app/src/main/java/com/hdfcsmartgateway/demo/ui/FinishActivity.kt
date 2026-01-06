package com.hdfcsmartgateway.demo.ui

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hdfcsmartgateway.demo.R
import com.hdfcsmartgateway.demo.models.handle.HandleResponse
import com.hdfcsmartgateway.demo.models.handle_request.HandleRequestBody
import com.hdfcsmartgateway.demo.network.Network
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FinishActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_finish)

        val i = intent
        val orderId = i.getStringExtra("orderId")

        Toast.makeText(applicationContext, orderId, Toast.LENGTH_SHORT).show()

        val handleRequestBody = HandleRequestBody(orderId = orderId!!)
        Network.Companion.service.handlePayment(handleRequestBody).enqueue(object :
            Callback<HandleResponse> {
            override fun onResponse(
                p0: Call<HandleResponse?>, response: Response<HandleResponse?>
            ) {
                val res = response.body()
                Log.d("API-STATUS", "SUCCESS")

                runOnUiThread {
                    Toast.makeText(
                        applicationContext, res!!.status, Toast.LENGTH_SHORT
                    ).show()
                }

            }

            override fun onFailure(
                p0: Call<HandleResponse?>, p1: Throwable
            ) {
                Log.d("API-STATUS", p1.message.toString())
            }

        })

    }

}