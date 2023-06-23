package com.example.morsacevir

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val timer = object : CountDownTimer(3500,1000){
            override fun onTick(p0: Long) {}
            override fun onFinish() {
                val intent = Intent(this@MainActivity,MorsActivity::class.java)
                startActivity(intent)
                finish()
            }
        }
        timer.start()
    }
}