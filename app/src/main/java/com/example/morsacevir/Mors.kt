package com.example.morsacevir

import java.util.*

object Mors {
    private val ALFABE = arrayOf(
        "a",
        "b",
        "c",
        "d",
        "e",
        "f",
        "g",
        "h",
        "i",
        "j",
        "k",
        "l",
        "m",
        "n",
        "o",
        "p",
        "q",
        "r",
        "s",
        "t",
        "u",
        "v",
        "w",
        "x",
        "y",
        "z",
        "1",
        "2",
        "3",
        "4",
        "5",
        "6",
        "7",
        "8",
        "9",
        "0",
        "!",
        ",",
        "?",
        ".",
        "'"
    )
    private val MORS = arrayOf(
        ".-",
        "-...",
        "-.-.",
        "-..",
        ".",
        "..-.",
        "--.",
        "....",
        "..",
        ".---",
        "-.-",
        ".-..",
        "--",
        "-.",
        "---",
        ".--.",
        "--.-",
        ".-.",
        "...",
        "-",
        "..-",
        "...-",
        ".--",
        "-..-",
        "-.--",
        "--..",
        ".----",
        "..---",
        "...--",
        "....-",
        ".....",
        "-....",
        "--...",
        "---..",
        "----.",
        "-----",
        "-.-.--",
        "--..--",
        "..--..",
        ".-.-.-",
        ".----."
    )

    private val ALFABE_TO_MORS: HashMap<String, String> = HashMap()
    private val MORS_TO_ALFABE: HashMap<String, String> = HashMap()

    init {
        for (i in ALFABE.indices) {
            if (i < MORS.size) {
                ALFABE_TO_MORS[ALFABE[i]] = MORS[i]
                MORS_TO_ALFABE[MORS[i]] = ALFABE[i]
            }
        }
    }

    fun morsToAlfabe(morseCode: String): String {
        val builder = StringBuilder()
        val words = morseCode.trim().split("  ")

        for (word in words) {
            for (letter in word.split(" ")) {
                val alpha = MORS_TO_ALFABE[letter]
                builder.append(alpha)
            }
            builder.append(" ")

        }
        return builder.toString().uppercase(Locale.ROOT)
    }

    fun alfabeToMors(turkceCode: String): String {
        val builder = StringBuilder()
        val words = turkceCode.trim().split(" ")

        for (word in words) {
            for (i in 0 until word.length) {
                val mors = ALFABE_TO_MORS[word.substring(i, i + 1).lowercase(Locale.ROOT)]
                builder.append(mors).append(" ")
            }
            builder.append(" ")
        }
        return builder.toString()
    }
}