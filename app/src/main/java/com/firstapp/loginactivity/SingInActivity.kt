package com.firstapp.loginactivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SingInActivity : AppCompatActivity() {

    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var btLogin: Button
    private lateinit var tvError: TextView
    private lateinit var loading: ProgressBar
    private lateinit var signupRedirect: TextView
    private lateinit var dbHelper: DatabaseHelper
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sing_in)

        // Initialize UI elements
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        btLogin = findViewById(R.id.submit)
        tvError = findViewById(R.id.error)
        loading = findViewById(R.id.loading)
        signupRedirect = findViewById(R.id.registration)

        // Initialize database helper and FirebaseAuth
        dbHelper = DatabaseHelper(this)
        auth = FirebaseAuth.getInstance()

        // Redirect to Sign Up page
        signupRedirect.setOnClickListener {
            startActivity(Intent(this, SignUpActivity::class.java))
            finish()
        }

        // Login Button Click
        btLogin.setOnClickListener {
            val emailText = email.text.toString().trim()
            val passwordText = password.text.toString().trim()

            if (emailText.isEmpty() || passwordText.isEmpty()) {
                showError("All fields are required!")
                return@setOnClickListener
            }

            loading.visibility = View.VISIBLE

            // Try Firebase authentication first
            auth.signInWithEmailAndPassword(emailText, passwordText)
                .addOnSuccessListener {
                    loading.visibility = View.GONE
                    Toast.makeText(applicationContext, "Login Successful!", Toast.LENGTH_SHORT).show()

                    // Sync Firebase user to SQLite if not exists
                    if (!dbHelper.isUserExists(emailText)) {
                        dbHelper.insertUser(it.user?.displayName ?: "User", emailText, passwordText)
                    }

                    startActivity(Intent(applicationContext, MainActivity::class.java))
                    finish()
                }
                .addOnFailureListener {
                    // If Firebase fails, check SQLite
                    if (dbHelper.readUser(emailText, passwordText)) {
                        loading.visibility = View.GONE
                        Toast.makeText(applicationContext, "Logged in with SQLite!", Toast.LENGTH_SHORT).show()
                        startActivity(Intent(applicationContext, MainActivity::class.java))
                        finish()
                    } else {
                        loading.visibility = View.GONE
                        showError("Invalid Email or Password!")
                    }
                }
        }
    }

    private fun showError(message: String) {
        tvError.text = message
        tvError.visibility = View.VISIBLE
    }
}
