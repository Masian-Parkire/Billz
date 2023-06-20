package com.example.hello

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast

import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout
import dev.masian.asses1.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       binding=MainActivity.inflate(layoutInflater)

        setContentView(binding.root)

    }

    override fun onResume() {
        super.onResume()

        binding.btnSignUp.setOnClickListener {
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
        }
        binding.btnSignUp.setOnClickListener {
            validateSignUp()
        }
    }


    fun validateSignUp() {
        val username=binding.etUserName.text.toString()
        val email =binding.etEmail.text.toString()
        val phone= binding.etPhoneNo.text.toString()
        val passy=binding.etPassword.text.toString()
        val confirmpass=binding.etPassConfirm.text.toString()
        var error = false



        if (username.isBlank()) {
            binding.tilUserName.error = "UserName is required"
            error = true
        }
        if (phone.isBlank()) {
            binding.tilPhoneNo.error = "Phone Number is required"
            error = true
        }
        if (email.isBlank()) {
            binding.tilEmail.error = "Email is required"
            error = true
        }
        if (passy.isBlank()) {
            binding.tilPassword.error = "Password is required"
            error = true
        }
        if (confirmpass.isBlank()) {
            binding. tilPassConfirm.error = "password confirmation is required"
            error = true
        }
        if (passy != confirmpass) {
            binding.tilPassConfirm.error = "password and confirmation do not match"
            error = true
        }
        if (!error) {
            Toast.makeText(this, "$username $phone $email", Toast.LENGTH_LONG).show()

        }

    }
}
















//    fun passWordValid(password:String):Boolean{
//        return (password.length in 8..15 )
//
//    }  // come back and work on it then invoke it.



