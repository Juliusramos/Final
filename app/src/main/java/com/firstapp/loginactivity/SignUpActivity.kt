package com.firstapp.loginactivity

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth

class SignUpActivity : AppCompatActivity() {

    private lateinit var name: EditText
    private lateinit var email: EditText
    private lateinit var password: EditText
    private lateinit var btSignUp: Button
    private lateinit var tvError: TextView
    private lateinit var tvbacklog: TextView
    private lateinit var loading: ProgressBar
    private lateinit var dbHelper: DatabaseHelper
    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        // Initialize UI elements
        name = findViewById(R.id.name)
        email = findViewById(R.id.email)
        password = findViewById(R.id.password)
        btSignUp = findViewById(R.id.submit)
        tvError = findViewById(R.id.error)
        loading = findViewById(R.id.loading)
        tvbacklog = findViewById(R.id.logoBackToLogin)

        // Initialize database helper
        dbHelper = DatabaseHelper(this)

        // Initialize Firebase Auth
        firebaseAuth = FirebaseAuth.getInstance()

        // Sign Up Button Click
        btSignUp.setOnClickListener {
            val nameText = name.text.toString().trim()
            val emailText = email.text.toString().trim()
            val passwordText = password.text.toString().trim()

            // Check if fields are empty
            if (nameText.isEmpty() || emailText.isEmpty() || passwordText.isEmpty()) {
                showError("All fields are required!")
                return@setOnClickListener
            }

            // Show loading
            loading.visibility = View.VISIBLE

            // Insert into SQLite
            if (dbHelper.isUserExists(emailText)) {
                loading.visibility = View.GONE
                showError("User already exists in SQLite!")
            } else {
                val result = dbHelper.insertUser(nameText, emailText, passwordText)
                if (result != -1L) {
                    // Sign up in Firebase
                    firebaseAuth.createUserWithEmailAndPassword(emailText, passwordText)
                        .addOnCompleteListener { task ->
                            loading.visibility = View.GONE
                            if (task.isSuccessful) {
                                Toast.makeText(applicationContext, "Sign-up Successful!", Toast.LENGTH_SHORT).show()
                                startActivity(Intent(this, SingInActivity::class.java))
                                finish()
                            } else {
                                showError("Firebase Sign-up failed: ${task.exception?.message}")
                            }
                        }
                } else {
                    loading.visibility = View.GONE
                    showError("SQLite Sign-up failed!")
                }
            }
        }
        tvbacklog.setOnClickListener{
            startActivity(Intent(this, SingInActivity::class.java))
            finish()
        }
    }

    // Helper function to display error message
    private fun showError(message: String) {
        tvError.text = message
        tvError.visibility = View.VISIBLE
    }
}
