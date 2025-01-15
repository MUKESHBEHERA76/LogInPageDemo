package com.harmonigate.loginpagedemo

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.util.Patterns
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

        username.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                if (!s.isNullOrEmpty() && !Patterns.EMAIL_ADDRESS.matcher(s).matches()) {
                    username.error = "Enter a valid email address"
                }
            }
            override fun afterTextChanged(s: Editable?) {}
        })

        // Add TextWatcher for Password validation
        password.addTextChangedListener(object : TextWatcher {
                    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
                    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                        if (!s.isNullOrEmpty() && !isPasswordValid(s.toString())) {
                            password.error = "Password must be at least 8 characters long, " +
                                    "include uppercase, lowercase, number, and special character"
                        }
                    }
                    override fun afterTextChanged(s: Editable?) {}
                })



        loginButton.setOnClickListener(){

            val email = username.text.toString().trim()
            val pwd = password.text.toString().trim()

            if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
                username.error = "Enter a valid email address"
                return@setOnClickListener
            }
            if (!isPasswordValid(pwd)) {
                password.error = "Password must be at least 8 characters long, " +
                        "include uppercase, lowercase, number, and special character"
                return@setOnClickListener
            }


            if (username.text.toString().equals("xyz@gmail.com") && password.text.toString().equals("Qwer@12345")){
                Toast.makeText(this, "You are successfully loggedIn!", Toast.LENGTH_SHORT).show()
            }
            else{
                Toast.makeText(this, "Incorrect credential please tru again!", Toast.LENGTH_SHORT).show()
            }
        }



    }
    // Password validation function
    private fun isPasswordValid(password: String): Boolean {
        val passwordPattern = Regex("^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@\$!%*?&#])[A-Za-z\\d@\$!%*?&#]{8,}$")
        return password.matches(passwordPattern)
    }
}