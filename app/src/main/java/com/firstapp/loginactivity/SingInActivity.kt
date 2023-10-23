package com.firstapp.loginactivity

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
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
import com.android.volley.VolleyError
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONException
import org.json.JSONObject


class SingInActivity : AppCompatActivity() {
    private lateinit var textsingup : TextView
    private lateinit var emailLog : EditText
    private lateinit var passwordLog: EditText
    private lateinit var buttonLog : Button
    private lateinit var tvError: TextView
    private lateinit var loading: ProgressBar
    private lateinit var sharedPreferences: SharedPreferences
    lateinit var name: String
    lateinit var email: String
    lateinit var apiKey: String

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_in)

        textsingup = findViewById(R.id.registration)
        emailLog = findViewById(R.id.email)
        passwordLog = findViewById(R.id.password)
        buttonLog = findViewById(R.id.submit)
        tvError = findViewById(R.id.error)
        loading = findViewById(R.id.loading)

        sharedPreferences = getSharedPreferences("MyAppName", MODE_PRIVATE)

        if (sharedPreferences.getString("logged", "false") == "true") {
            val intent = Intent(applicationContext, MainActivity::class.java)
            startActivity(intent)
            finish()
        }

        buttonLog.setOnClickListener{
            tvError.visibility = View.GONE
            loading.visibility = View.VISIBLE
            val emailText = emailLog.text.toString()
            val passwordText = passwordLog.text.toString()
            val queue = Volley.newRequestQueue(applicationContext)
            val url = "http://172.20.10.2/LoginRegister/login.php"

            val stringRequest = object : StringRequest(Request.Method.POST, url,
                Response.Listener<String> { response ->
                    loading.visibility = View.GONE
                    try {
                        val jsonObject = JSONObject(response)
                        val status = jsonObject.getString("status")
                        val message = jsonObject.getString("message")

                        if (status == "success") {
                            name = jsonObject.getString("name")
                            email = jsonObject.getString("email")
                            apiKey = jsonObject.getString("apiKey")

                            val editor = sharedPreferences.edit()
                            editor.putString("logged", "true")
                            editor.putString("name", name)
                            editor.putString("email", email)
                            editor.putString("apiKey", apiKey)
                            editor.apply()
                            Toast.makeText(this, "Account SignIn. Welcome!", Toast.LENGTH_SHORT).show()
                            val intent = Intent(applicationContext, MainActivity::class.java)
                            startActivity(intent)
                            finish()
                        } else if (status == "failed" && message == "All fields are required") {
                            tvError.text = "Please fill in all fields."
                            tvError.visibility = View.VISIBLE
                        } else {
                            tvError.text = "Login failed"
                            tvError.visibility = View.VISIBLE
                        }
                    } catch (e: JSONException) {
                        e.printStackTrace()
                    }
                },
                Response.ErrorListener { error: VolleyError ->
                    loading.visibility = View.GONE
                    Log.e("Volley Error", error.toString())
                    tvError.text = "Login failed. Check network connection and server."
                    tvError.visibility = View.VISIBLE
                }) {
                override fun getParams(): MutableMap<String, String> {
                    val paramV = HashMap<String, String>()
                    paramV["email"] = emailText
                    paramV["password"] = passwordText
                    return paramV
                }
            }
            queue.add(stringRequest)
        }

        textsingup.setOnClickListener(){
            val intent = Intent(applicationContext, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}