package com.example.morscevirisi

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var metin : EditText = findViewById(R.id.metin)
        var metinCevirisi : TextView = findViewById(R.id.metinCevirisi)
        var morsCevir : Button = findViewById(R.id.morsCevir)
        var turkCevir : Button = findViewById(R.id.turkCevir)
        var kopyala : Button = findViewById(R.id.kopyala)

        fun copyTextToClipboard() {
            val textToCopy = metinCevirisi.text
            val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
            val clipData = ClipData.newPlainText("text", textToCopy)
            clipboardManager.setPrimaryClip(clipData)
            Toast.makeText(this, "metin kopyalandı", Toast.LENGTH_LONG).show()
        }

       morsCevir.setOnClickListener {
           var metin1 = metin.text.toString()
           //metin.setText(" ")
           var metin2 = Mors.alfabeToMors(metin1)
           metinCevirisi.setText(metin2)


       }
        turkCevir.setOnClickListener {
            var metin1 = metin.text.toString()
            //metin.setText(" ")
            var metin2 = Mors.morsToAlfabe(metin1)
            metinCevirisi.setText(metin2)
        }
        kopyala.setOnClickListener {
            copyTextToClipboard()
        }


    }
}