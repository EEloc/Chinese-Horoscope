package com.example.horscopochino

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class AboutActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_about)
        val btnBack = findViewById<Button>(R.id.btn_aboutback)
        btnBack.setOnClickListener { finish() }
    }

}