package com.example.virtuallearnapp


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btn_click= findViewById<ImageButton>(R.id.logoButton)
        btn_click.setOnClickListener {
            val intent = Intent(this, Conditions::class.java)
            // start your next activity
            startActivity(intent)
        }

    }
}