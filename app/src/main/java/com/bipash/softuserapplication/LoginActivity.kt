package com.bipash.softuserapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var etUsername : EditText
    private lateinit var etPassword : EditText
    private lateinit var btnLogin : Button

    override fun onCreate(savedInstanceState: Bundle?){
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        etUsername = findViewById(R.id.etUsername)
        etPassword = findViewById(R.id.etPassword)
        btnLogin = findViewById(R.id.btnLogin)

        btnLogin.setOnClickListener (this)

    }

    override fun onClick(v: View?) {
        when(v?.id){
            btnLogin.id -> {
                val username = etUsername.toString()
                val password = etPassword.toString()
                if (username == "softwarica" && password == "coventry") {
                    val intent = Intent(this, MainActivity::class.java)
                    startActivity(intent)

                } else {
                    Toast.makeText(this, "invalid username", Toast.LENGTH_SHORT).show()
                    clean()
                }
            }
        }
    }

    private fun clean(){
        etUsername.setText(" ")
        etPassword.setText(" ")
        etUsername.requestFocus()
    }
}