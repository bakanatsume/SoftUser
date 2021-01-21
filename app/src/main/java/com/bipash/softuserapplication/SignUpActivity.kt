package com.bipash.softuserapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText

class SignUpActivity : AppCompatActivity(), View.OnClickListener{

    private lateinit var etFirst : EditText
    private lateinit var etLast : EditText
    private lateinit var etUsername : EditText
    private lateinit var etConfirm : EditText
    private lateinit var etPassword : EditText

    private lateinit var btnRegister : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_up)

        etFirst = findViewById(R.id.etFirst)
        etLast = findViewById(R.id.etLast)
        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        etConfirm = findViewById(R.id.etConfirm)
        btnRegister = findViewById(R.id.btnRegister)

        btnRegister.setOnClickListener(this)


    }

    override fun onClick(v: View?) {
        when(v?.id){
            btnRegister.id->{
                val intent = Intent(this, LoginActivity::class.java)
                startActivity(intent)
            }
        }
    }
}