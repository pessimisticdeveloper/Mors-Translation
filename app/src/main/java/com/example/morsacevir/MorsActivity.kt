package com.example.morsacevir

import android.content.ClipData
import android.content.ClipboardManager
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.*

class MorsActivity : AppCompatActivity() {

    private lateinit var metin: EditText
    private lateinit var metinCevirisi: TextView
    private lateinit var morsCevir : Button
    private lateinit var turkCevir : Button
    private lateinit var kopyala: ImageButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mors)

        metin = findViewById(R.id.metin)
        metinCevirisi = findViewById(R.id.metinCevirisi)
        morsCevir = findViewById(R.id.morsaCevir)
        turkCevir = findViewById(R.id.turkCevir)
        kopyala = findViewById(R.id.copy)

        morsCevir.setOnClickListener {
            val metin1 = metin.text.toString()
            //metin.setText(" ")
            val metin2 = Mors.alfabeToMors(metin1)
            metinCevirisi.setText(metin2)
        }
        turkCevir.setOnClickListener {
            val metin1 = metin.text.toString()
            //metin.setText(" ")
            val metin2 = Mors.morsToAlfabe(metin1)
            metinCevirisi.setText(metin2)
        }
        kopyala.setOnClickListener {
            copyTextToClipboard()
            metin.setText(" ")
        }
    }
    fun copyTextToClipboard() {
        val textToCopy = metinCevirisi.text
        val clipboardManager = getSystemService(Context.CLIPBOARD_SERVICE) as ClipboardManager
        val clipData = ClipData.newPlainText("text", textToCopy)
        clipboardManager.setPrimaryClip(clipData)
        Toast.makeText(this, "Metin Kopyalandı", Toast.LENGTH_LONG).show()
    }
}