package com.example.otpvarification

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthProvider

class VarifyOtp2 : AppCompatActivity() {

    lateinit var enteredOTP : EditText
    lateinit var varifyOtpBtn : Button

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_varify_otp2)

        auth = FirebaseAuth.getInstance()
        val storeVerificationId = intent.getStringExtra("storedVarificationId").toString()


        val mPhoneNumber = intent.getStringExtra("mNumber").toString()
        val phoneNumber = findViewById<TextView>(R.id.number1)
        phoneNumber.text = mPhoneNumber


        enteredOTP = findViewById(R.id.otp)
        varifyOtpBtn = findViewById(R.id.varifyotpBtn)

        varifyOtpBtn.setOnClickListener{
            val otp = enteredOTP.text.trim().toString()
            if(otp.isNotEmpty()){
                val credential : PhoneAuthCredential = PhoneAuthProvider.getCredential(storeVerificationId,otp)
                signInWithPhoneAuthCredential(credential)
            }else {
                Toast.makeText(applicationContext, "enter OTP", Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun signInWithPhoneAuthCredential(credential: PhoneAuthCredential) {
        auth.signInWithCredential(credential).addOnCompleteListener(this) { task ->
                if(task.isComplete){
                    val intent = Intent(applicationContext,FinalActivity::class.java)
                    startActivity(intent)
                    finish()
                } else {
                    if(task.exception is FirebaseAuthInvalidCredentialsException){
                        Toast.makeText(applicationContext,"Invalid OTP", Toast.LENGTH_SHORT).show()
                    }
                }
        }
    }
}