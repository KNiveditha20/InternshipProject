package com.example.virtuallearnapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class RegisterPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register_page)

        val login_button= findViewById<TextView>(R.id.loginBtnView)
        login_button.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            // start your next activity
            startActivity(intent)
        }

        val continue_button= findViewById<TextView>(R.id.continueBtn)
        continue_button.setOnClickListener {
            val intent = Intent(this, VerificationPage::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}