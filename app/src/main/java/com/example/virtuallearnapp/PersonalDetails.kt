package com.example.virtuallearnapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class PersonalDetails : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_personal_details)

        val register_complete_button= findViewById<Button>(R.id.reg_button)
        register_complete_button.setOnClickListener {
            val intent = Intent(this, RegistrationSuccessfull::class.java)
            // start your next activity
            startActivity(intent)
        }
    }
}