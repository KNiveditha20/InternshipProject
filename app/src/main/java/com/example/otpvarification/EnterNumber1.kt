package com.example.otpvarification

import android.content.ComponentCallbacks
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.firebase.FirebaseException
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.PhoneAuthCredential
import com.google.firebase.auth.PhoneAuthOptions
import com.google.firebase.auth.PhoneAuthProvider
import java.util.*
import java.util.concurrent.TimeUnit

class EnterNumber1 : AppCompatActivity() {

    lateinit var phoneNumber : EditText
    lateinit var submitBtn : Button

    lateinit var auth : FirebaseAuth
    lateinit var storedVarificationId : String
    lateinit var resendToken : PhoneAuthProvider.ForceResendingToken
    private lateinit var callbacks: PhoneAuthProvider.OnVerificationStateChangedCallbacks

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enternumber1)

        auth = FirebaseAuth.getInstance()
        callbacks = object : PhoneAuthProvider.OnVerificationStateChangedCallbacks(){
            override fun onVerificationCompleted(p0: PhoneAuthCredential) {
                val intent = Intent(applicationContext, FinalActivity::class.java)
                startActivity(intent)
                finish()
            }

            override fun onVerificationFailed(p0: FirebaseException) {
                Toast.makeText(applicationContext,"Varification failed", Toast.LENGTH_SHORT).show()
            }

            override fun onCodeSent(verificationId: String, token: PhoneAuthProvider.ForceResendingToken) {
                storedVarificationId = verificationId
                resendToken = token

                val intent = Intent(applicationContext, VarifyOtp2::class.java)
                intent.putExtra("storedVarificationId",verificationId)
                intent.putExtra("mNumber", phoneNumber.text.trim().toString())
                startActivity(intent)
                finish()
            }

        }
        submitBtn = findViewById(R.id.submitBtn)
        submitBtn.setOnClickListener{
            login()
        }
    }

    private fun login() {
        phoneNumber = findViewById(R.id.phoneNumber)
        var number = phoneNumber.text.trim().toString()

        if(number.isEmpty() || number.length!=10){
            Toast.makeText(this,"Enter proper phone number", Toast.LENGTH_SHORT).show()
        } else {
            number = "+91"+number
            sendVerificationCode(number)
        }
    }

    private fun sendVerificationCode(number: String) {
        val options = PhoneAuthOptions.newBuilder(auth)
            .setPhoneNumber(number)
            .setTimeout(60L,TimeUnit.SECONDS)
            .setActivity(this)
            .setCallbacks(callbacks)
            .build()
        PhoneAuthProvider.verifyPhoneNumber(options)

    }


}
