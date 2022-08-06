package com.example.virtuallearnapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class Conditions : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_conditions)

        val next_page= findViewById<ImageButton>(R.id.forwardButton)
        next_page.setOnClickListener {
            val intent = Intent(this, Onboarding::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}