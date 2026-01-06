package com.hdfcsmartgateway.demo.ui

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.gson.Gson
import com.hdfcsmartgateway.demo.R
import com.hdfcsmartgateway.demo.models.initiate.InitiateResponse
import com.hdfcsmartgateway.demo.network.Network
import `in`.juspay.hypercheckoutlite.HyperCheckoutLite
import `in`.juspay.hypersdk.data.JuspayResponseHandler
import `in`.juspay.hypersdk.ui.HyperPaymentsCallbackAdapter
import org.json.JSONObject
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private var progressDialogFragment: ProgressDialogFragment? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        progressDialogFragment = ProgressDialogFragment()

        findViewById<Button>(R.id.button).setOnClickListener {

            progressDialogFragment!!.show(supportFragmentManager, "ProgressDialogFragment")

            val payload = JSONObject()

            val randomOrderId = (Math.random() * 10.0.pow(12.0)).toLong()
            val orderId = "test-$randomOrderId"
            try {
                payload.put("order_id", orderId) // OrderID should be unique
                payload.put("amount", "10.00") // Amount should be in strings e.g. "100.00"
                payload.put(
                    "customer_id",
                    "testing-customer-one"
                ) // Customer ID should be unique for each user and should be a string
                payload.put("customer_email", "abcde@mail.com")
                payload.put("customer_phone", "1234567890")
                payload.put("action", "paymentPage")
            } catch (e: Exception) {
                Log.d("juspay", e.toString())
            }

            Network.service.getPaymentInfo().enqueue(object : Callback<InitiateResponse> {
                override fun onResponse(
                    p0: Call<InitiateResponse?>, response: Response<InitiateResponse?>
                ) {
                    val res = response.body()
                    Log.d("STATUS", "SUCCESS")

                    progressDialogFragment!!.dismiss()

                    val sdkPayload = JSONObject(Gson().toJson(res?.sdk_payload))
                    runOnUiThread {
                        HyperCheckoutLite.openPaymentPage(
                            this@MainActivity,
                            sdkPayload,
                            createHyperPaymentsCallbackAdapter()
                        )
                        Toast.makeText(
                            applicationContext,
                            "Opening Payment Page",
                            Toast.LENGTH_SHORT
                        ).show()
                    }

                }

                override fun onFailure(
                    p0: Call<InitiateResponse?>, p1: Throwable
                ) {
                    progressDialogFragment!!.dismiss()
                    Log.d("STATUS", p1.message.toString())
                }

            })
        }
    }

    private fun createHyperPaymentsCallbackAdapter(): HyperPaymentsCallbackAdapter {
        return object : HyperPaymentsCallbackAdapter() {
            override fun onEvent(jsonObject: JSONObject, responseHandler: JuspayResponseHandler) {
                val redirect = Intent(this@MainActivity, FinishActivity::class.java)
                try {
                    val event = jsonObject.getString("event")
                    when (event) {
                        "hide_loader" -> {

                        }

                        "process_result" -> {
                            val innerPayload = jsonObject.optJSONObject("payload")
                            val status = innerPayload?.optString("status")
                            when (status) {
                                "backpressed", "user_aborted" -> {
                                    Toast.makeText(
                                        applicationContext,
                                        "User Aborted",
                                        Toast.LENGTH_SHORT
                                    ).show()
                                }

                                else -> {
                                    val orderId = jsonObject.getString("orderId")
                                    Log.d("ORDERID", orderId)
                                    redirect.putExtra("orderId", orderId)
                                    startActivity(redirect)
                                }
                            }
                        }
                    }
                } catch (e: Exception) {
                    // merchant code...
                }
            }
        }
    }
}