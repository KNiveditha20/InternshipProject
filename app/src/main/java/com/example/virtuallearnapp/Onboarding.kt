package com.example.virtuallearnapp

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class Onboarding : AppCompatActivity() {
    @SuppressLint("CutPasteId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_onboarding)

        val register_button= findViewById<Button>(R.id.registerBtn)
        register_button.setOnClickListener {
            val intent = Intent(this, RegisterPage::class.java)
            // start your next activity
            startActivity(intent)
        }
        val login_button= findViewById<Button>(R.id.loginBtn)
        login_button.setOnClickListener {
            val intent = Intent(this, LoginPage::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}