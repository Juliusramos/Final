package com.firstapp.loginactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.firstapp.loginactivity.databinding.ActivitySingInBinding

class SingInActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySingInBinding
    private lateinit var databaseHelper: DatabaseHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySingInBinding.inflate(layoutInflater)
        setContentView(binding.root)

        databaseHelper = DatabaseHelper(this)

        binding.btLogin.setOnClickListener{
            val email = binding.etEmailLogin.text.toString()
            val password = binding.etPassword.text.toString()
            loginDatabase(email, password)
        }
        binding.tvSignUp.setOnClickListener {
            val intent = Intent(this, SignUpActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun loginDatabase(email:String, password:String){
        val userExists = databaseHelper.readUser(email, password)
        if (userExists){
            Toast. makeText(this,"Login Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
            finish()
        }else{
            Toast. makeText(this,"Login Failed", Toast.LENGTH_SHORT).show()
        }

    }
}