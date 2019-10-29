package com.example.responsi284


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.register1.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button_login.setOnClickListener {
            val email = login_email.text.toString()
            val password = login_password.text.toString()
            if (email.isEmpty() || password.isEmpty()) {
                Toast.makeText(this, "Please Insert Email and Password", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            if (email == "muhammadamin3262@gmail.com" || password =="qwerty123") {
                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
            }
        }

        button_daftar.setOnClickListener{
            val intent = Intent (this, button_register::class.java)
            startActivity(intent)
        }
    }
}
