package com.firstapp.loginactivity

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class SignUpActivity : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var btRegister: Button
    private lateinit var tvError: TextView
    private lateinit var loading: ProgressBar
    private lateinit var backtosign: TextView
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        btRegister = findViewById(R.id.submit)
        tvError = findViewById(R.id.error)
        loading = findViewById(R.id.loading)

        backtosign = findViewById(R.id.logoBackToLogin)

        backtosign.setOnClickListener{
            val intent = Intent(this,SingInActivity::class.java)
            startActivity(intent)
            finish()
        }


        btRegister.setOnClickListener {
            val nameText = name.text.toString()
            val emailText = email.text.toString()
            val passwordText = password.text.toString()

            if (nameText.isEmpty() || emailText.isEmpty() || passwordText.isEmpty()) {
                Toast.makeText(applicationContext, "All fields are required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            tvError.visibility = View.GONE
            loading.visibility = View.VISIBLE

            val queue = Volley.newRequestQueue(applicationContext)
            val url = "http://172.20.10.2/LoginRegister/register.php"

            val stringRequest = object : StringRequest(
                Request.Method.POST, url,
                Response.Listener<String> { response ->
                    loading.visibility = View.GONE
                    if (response == "success") {
                        Toast.makeText(applicationContext, "Registration successful", Toast.LENGTH_SHORT).show()
                        Log.d("SingInActivity", "Starting SingInActivity")
                        val intent = Intent(applicationContext, SingInActivity::class.java)
                        startActivity(intent)
                        finish()
                    } else {
                        // Handle specific error messages from the server here
                        tvError.text = response
                        tvError.text = "Network Error"
                        tvError.visibility = View.VISIBLE
                    }
                },
                Response.ErrorListener { error ->
                    loading.visibility = View.GONE
                    tvError.text = "Network Error"
                    tvError.visibility = View.VISIBLE
                }) {
                override fun getParams(): MutableMap<String, String> {
                    val paramV = HashMap<String, String>()
                    paramV["name"] = nameText
                    paramV["email"] = emailText
                    paramV["password"] = passwordText
                    return paramV
                }
            }
            queue.add(stringRequest)
        }
    }
}