package com.firstapp.loginactivity

import android.content.Intent
import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import okhttp3.*
import org.json.JSONObject
import java.io.IOException

class OTPTwilioActivity : AppCompatActivity() {

    private lateinit var phoneNumber: EditText
    private lateinit var sendOtpButton: Button
    private lateinit var otpCode: EditText
    private lateinit var verifyOtpButton: Button
    private lateinit var timerText: TextView
    private var isCooldownActive = false

    private val client = OkHttpClient()

    // Hardcoded Twilio Credentials
    private val serviceSid = "VAe39d82eeded973893d578c6ce36f4e6b"
    private val accountSid = "ACefcdc33e340d379556d47eeeefbaaa7e"
    private val authToken = "226fd6daf9a5c6a8d7d4720c6a48c3c9"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_otptwilio)

        phoneNumber = findViewById(R.id.phoneNumber)
        sendOtpButton = findViewById(R.id.sendOtpButton)
        otpCode = findViewById(R.id.otpCode)
        verifyOtpButton = findViewById(R.id.verifyOtpButton)
        timerText = findViewById(R.id.timerText)

        sendOtpButton.setOnClickListener {
            if (!isCooldownActive) {
                sendOtp()
            }
        }

        verifyOtpButton.setOnClickListener {
            verifyOtp()
        }
    }

    private fun sendOtp() {
        val phone = phoneNumber.text.toString().trim()
        if (phone.isEmpty() || phone.length < 10) {
            Toast.makeText(this, "Enter a valid phone number", Toast.LENGTH_SHORT).show()
            return
        }

        val url = "https://verify.twilio.com/v2/Services/$serviceSid/Verifications"
        val requestBody = FormBody.Builder()
            .add("To", phone)
            .add("Channel", "sms")
            .build()

        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .addHeader("Authorization", Credentials.basic(accountSid, authToken))
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    Toast.makeText(applicationContext, "Failed to send OTP", Toast.LENGTH_SHORT).show()
                    Log.e("Twilio", "Error: ${e.message}")
                }
            }

            override fun onResponse(call: Call, response: Response) {
                if (response.isSuccessful) {
                    runOnUiThread {
                        Toast.makeText(applicationContext, "OTP sent to $phone", Toast.LENGTH_SHORT).show()
                        startCooldown()
                    }
                } else {
                    runOnUiThread {
                        Toast.makeText(applicationContext, "Error sending OTP", Toast.LENGTH_SHORT).show()
                        Log.e("Twilio", "Response: ${response.body?.string()}")
                    }
                }
            }
        })
    }

    private fun startCooldown() {
        isCooldownActive = true
        sendOtpButton.isEnabled = false
        timerText.visibility = View.VISIBLE

        object : CountDownTimer(30000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                val secondsRemaining = millisUntilFinished / 1000
                timerText.text = "Wait $secondsRemaining seconds before resending OTP."
            }

            override fun onFinish() {
                isCooldownActive = false
                sendOtpButton.isEnabled = true
                timerText.visibility = View.GONE
            }
        }.start()
    }

    private fun verifyOtp() {
        val phone = phoneNumber.text.toString().trim()
        val otp = otpCode.text.toString().trim()

        if (otp.length != 6) {
            Toast.makeText(this, "Enter a valid 6-digit OTP", Toast.LENGTH_SHORT).show()
            return
        }

        val url = "https://verify.twilio.com/v2/Services/$serviceSid/VerificationCheck"
        val requestBody = FormBody.Builder()
            .add("To", phone)
            .add("Code", otp)
            .build()

        val request = Request.Builder()
            .url(url)
            .post(requestBody)
            .addHeader("Authorization", Credentials.basic(accountSid, authToken))
            .build()

        client.newCall(request).enqueue(object : Callback {
            override fun onFailure(call: Call, e: IOException) {
                runOnUiThread {
                    Toast.makeText(applicationContext, "OTP verification failed", Toast.LENGTH_SHORT).show()
                    Log.e("Twilio", "Error: ${e.message}")
                }
            }

            override fun onResponse(call: Call, response: Response) {
                val responseBody = response.body?.string()
                val jsonResponse = JSONObject(responseBody ?: "")

                if (jsonResponse.optString("status") == "approved") {
                    runOnUiThread {
                        Toast.makeText(applicationContext, "OTP Verified!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(applicationContext, MainActivity::class.java))
                        finish()
                    }
                } else {
                    runOnUiThread {
                        Toast.makeText(applicationContext, "Invalid OTP", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        })
    }
}
