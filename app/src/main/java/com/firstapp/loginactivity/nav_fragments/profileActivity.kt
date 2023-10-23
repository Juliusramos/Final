package com.firstapp.loginactivity.nav_fragments

import android.annotation.SuppressLint
import android.content.Intent
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.firstapp.loginactivity.MainActivity
import com.firstapp.loginactivity.R

class profileActivity : AppCompatActivity() {
    private lateinit var back: ImageView
    private lateinit var nameProfile: TextView
    private lateinit var emailProfile: TextView
    private lateinit var sharedPreferences: SharedPreferences

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_profile)

        // Initialize sharedPreferences
        sharedPreferences = getSharedPreferences("MyAppName", MODE_PRIVATE)

        back = findViewById(R.id.backtoHome)
        nameProfile = findViewById(R.id.nameprofile)
        emailProfile = findViewById(R.id.emailprofile)

        nameProfile.text = sharedPreferences.getString("name", "")
        emailProfile.text = sharedPreferences.getString("email", "")

        back.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}