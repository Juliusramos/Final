package com.firstapp.loginactivity

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.firstapp.loginactivity.databinding.ActivityMainBinding
import com.firstapp.loginactivity.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySignUpBinding
    private lateinit var databaseHelper: DatabaseHelper


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding.root)


        databaseHelper = DatabaseHelper(this)

        binding.btButtonSignUp.setOnClickListener{
            val email = binding.etEmail.text.toString()
            val password = binding.etPasswordSignup.text.toString()
            val firstname = binding.etFName.text.toString()
            val lastname = binding.etLName.text.toString()
            signupDatabase(firstname,lastname,email, password)
        }
        binding.tvRegistered.setOnClickListener{
            val intent = Intent(this, SingInActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
    private fun signupDatabase(firstname:String,lastname: String,email:String, password:String){
        val insertedRowId = databaseHelper.insertUser(firstname,lastname,email, password)
        if(insertedRowId != -1L){
            Toast.makeText(this,"Signup Successful", Toast.LENGTH_SHORT).show()
            val intent = Intent(this,SingInActivity::class.java)
            startActivity(intent)
        }else{
            Toast.makeText(this,"Signup Field", Toast.LENGTH_SHORT).show()
        }
    }
}