package com.example.horscopochino

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.RequiresApi
import java.time.*
import java.util.*

class HoroscopeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_horoscope)
        val txtHoroscopeSign = findViewById<TextView>(R.id.txt_horoscopesign)
        val txtAge = findViewById<TextView>(R.id.txt_age)
        val txtSignDescription = findViewById<TextView>(R.id.txt_signdescription)
        val imgSign = findViewById<ImageView>(R.id.img_sign)
        val btnBack = findViewById<Button>(R.id.btn_horoscopeback)
        var username: String = ""
        var userbirthday: String = Calendar.getInstance().get(Calendar.YEAR).toString()
        intent.extras?.let { bundle ->
            username = bundle.getString("name")?: ""
            userbirthday = bundle.getString("birthday")?: ""
        }
        val sign = asignSign(Integer.parseInt(userbirthday.substring(userbirthday.length - 4)))
        val agevalue = calculateAge(userbirthday)
        val horoscope = "$username " + getString(R.string.str_horoscope) +" "+ getText(giveSign(sign))
        txtHoroscopeSign.text = horoscope
        val ageformat= getString(R.string.str_age)+ "$agevalue " + getString(R.string.str_ageunity)
        txtAge.text = ageformat
        txtSignDescription.text = getText(giveSignDescription(sign))
        imgSign.setImageResource(giveSignImage(sign))
        btnBack.setOnClickListener { finish() }
    }
    private fun calculateAge(birthday: String): Int{
        val day = Integer.parseInt(birthday.substring(0,1))
        val month = Integer.parseInt(birthday.substring(3,4))
        val year = Integer.parseInt(birthday.substring(6))
        val todayDate = Calendar.getInstance()
        val age: Int
        if(month == todayDate.get(Calendar.MONTH) && day < todayDate.get(Calendar.DAY_OF_MONTH))
            age = todayDate.get(Calendar.YEAR) - year - 1
        else
            age = todayDate.get(Calendar.YEAR) - year
        return age
    }
    private fun asignSign(year: Int): Int {
        return ((year - 1936) % 12)
    }
    private fun giveSign(indx: Int): Int {
        if (indx == 0) return R.string.str_srat
        if (indx == 1) return R.string.str_sox
        if (indx == 2) return R.string.str_stiger
        if (indx == 3) return R.string.str_srabbit
        if (indx == 4) return R.string.str_sdragon
        if (indx == 5) return R.string.str_ssnake
        if (indx == 6) return R.string.str_shorse
        if (indx == 7) return R.string.str_sgoat
        if (indx == 8) return R.string.str_smonkey
        if (indx == 9) return R.string.str_srooster
        if (indx == 10) return R.string.str_sdog
        return R.string.str_spig
    }
    private fun giveSignDescription(indx: Int): Int {
        if (indx == 0) return R.string.des_rat
        if (indx == 1) return R.string.des_ox
        if (indx == 2) return R.string.des_tiger
        if (indx == 3) return R.string.des_rabbit
        if (indx == 4) return R.string.des_dragon
        if (indx == 5) return R.string.des_snake
        if (indx == 6) return R.string.des_horse
        if (indx == 7) return R.string.des_goat
        if (indx == 8) return R.string.des_monkey
        if (indx == 9) return R.string.des_rooster
        if (indx == 10) return R.string.des_dog
        return R.string.des_pig
    }
    private fun giveSignImage(indx: Int): Int {
        if (indx == 0) return R.drawable.a_rat
        if (indx == 1) return R.drawable.b_ox
        if (indx == 2) return R.drawable.c_tiger
        if (indx == 3) return R.drawable.d_rabbit
        if (indx == 4) return R.drawable.e_dragon
        if (indx == 5) return R.drawable.f_snake
        if (indx == 6) return R.drawable.g_horse
        if (indx == 7) return R.drawable.h_goat
        if (indx == 8) return R.drawable.i_monkey
        if (indx == 9) return R.drawable.j_rooster
        if (indx == 10) return R.drawable.k_dog
        return R.drawable.l_pig
    }

}