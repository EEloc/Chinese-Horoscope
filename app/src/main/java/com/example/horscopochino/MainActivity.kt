package com.example.horscopochino

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        getReadyFormatActivityButton()
        getReadyAboutActivityButton()
    }

    private fun getReadyFormatActivityButton(){
        val btnRegister = findViewById<Button>(R.id.btn_register)
        btnRegister.setOnClickListener {
            val intentFormatA = Intent(this, FormatActivity::class.java)
            startActivity(intentFormatA)
        }
    }

    private fun getReadyAboutActivityButton(){
        val btnAbout = findViewById<Button>(R.id.btn_abouthoroscope)
        btnAbout.setOnClickListener {
            val intentAbout = Intent(this, AboutActivity::class.java)
            startActivity(intentAbout)
        }
    }

}