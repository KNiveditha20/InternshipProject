package com.example.virtuallearnapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView

class VerificationPage : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_verification_page)
        val verify_button= findViewById<Button>(R.id.verifyBtn)
        verify_button.setOnClickListener {
            val intent = Intent(this, PersonalDetails::class.java)
            // start your next activity
            startActivity(intent)
        }

    }
}