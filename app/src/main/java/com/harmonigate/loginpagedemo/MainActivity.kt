package com.harmonigate.loginpagedemo

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        val loginButton=findViewById<Button>(R.id.btn_logIn)
        val username=findViewById<EditText>(R.id.et_userName)
        val password=findViewById<EditText>(R.id.et_password)


        loginButton.setOnClickListener(){
            if (username.text.toString().equals("Administrator") && password.text.toString().equals("manage")){
                Toast.makeText(this, "You are successfully loggedIn!", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Incorrect credential please tru again!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}