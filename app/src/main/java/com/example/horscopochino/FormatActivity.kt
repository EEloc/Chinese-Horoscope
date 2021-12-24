package com.example.horscopochino

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.util.*

class FormatActivity : AppCompatActivity() {
    private var etxBirthday: EditText? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_format)
        getReadyReadHoroscopeButton()
        getReadyCancelButton()
    }
    private fun getReadyReadHoroscopeButton(){
        val etxName = findViewById<EditText>(R.id.etx_namefield)
        etxBirthday = findViewById<EditText>(R.id.etx_birthdayfield)
        datePickerFuntionality();
        val etxAccount = findViewById<EditText>(R.id.etx_accountfield)
        val etxEmail = findViewById<EditText>(R.id.etx_emailfield)
        val btnReadHoroscope = findViewById<Button>(R.id.btn_readhoroscope)
        btnReadHoroscope.setOnClickListener {
            if (areFieldsCorrectlyFilled(etxName, etxBirthday, etxAccount, etxEmail)) {
                val intentHoroscopeA = Intent(this, HoroscopeActivity::class.java)
                intentHoroscopeA.putExtra("name", etxName.text.toString())
                intentHoroscopeA.putExtra("birthday", etxBirthday?.text.toString())
                startActivity(intentHoroscopeA)
            } else showToast(getString(R.string.msj_fillblanks))
        }
    }

    private fun datePickerFuntionality() {
        etxBirthday?.setOnClickListener {
            val datePicker = DatePickerFragment{day, month, year -> onDaySelected(day, year, month)}
            datePicker.show(supportFragmentManager, "datepicker")
        }
    }
    private fun onDaySelected(day: Int, year: Int, month: Int){
        val dateFormat: String
        val dayT: String
        val monthT: String
        if(day < 10) dayT = "0$day"
        else dayT = "$day"
        if(month + 1 < 10) monthT = "0"+(month + 1)
        else monthT = ""+(month + 1)
        dateFormat = "$dayT/$monthT/$year"
        etxBirthday?.setText(dateFormat)
    }

    private fun areFieldsCorrectlyFilled(etxName: EditText, etxBirthday: EditText?,
                                         etxAccount: EditText, etxEmail: EditText): Boolean{
        var canSave = true
        if(etxName.text.toString() == "") canSave = false
        if(etxBirthday?.text.toString() == "") canSave = false
        if(etxAccount.text.toString() == "") canSave = false
        if(etxAccount.text.toString().length != 16) canSave = false
        if(etxAccount.text.toString() == "") canSave = false
        if(etxEmail.text.toString() == "") canSave = false
        return canSave
    }

    private fun showToast(text:String){
        Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
    }

    private fun getReadyCancelButton(){
        val btnCancel = findViewById<Button>(R.id.btn_cancel)
        btnCancel.setOnClickListener { finish() }
    }
}