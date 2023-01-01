package com.example.morscevirisi;

import java.util.HashMap;
import java.util.Locale;

public class Mors {
    static String[] ALFABE = { "a", "b", "c", "d", "e", "f", "g", "h", "i", "j", "k", "l", "m", "n", "o", "p", "q", "r",
            "s", "t", "u", "v", "w", "x", "y", "z", "1", "2", "3", "4", "5", "6", "7", "8", "9", "0", "!", ",", "?",
            ".", "'"};
    static String[] MORS = { ".-", "-...", "-.-.", "-..", ".", "..-.", "--.", "....", "..", ".---", "-.-", ".-..",
            "--", "-.", "---", ".--.", "--.-", ".-.", "...", "-", "..-", "...-", ".--", "-..-", "-.--", "--..", ".----",
            "..---", "...--", "....-", ".....", "-....", "--...", "---..", "----.", "-----", "-.-.--", "--..--",
            "..--..", ".-.-.-", ".----.",};

    public static HashMap<String,String> ALFABE_TO_MORS = new HashMap<>();
    public static HashMap<String,String> MORS_TO_ALFABE = new HashMap<>();

    static {
        for (int i = 0; i < ALFABE.length && i < MORS.length; i++) {
            ALFABE_TO_MORS.put(ALFABE[i],MORS[i]);
            MORS_TO_ALFABE.put(MORS[i],ALFABE[i]);
        }
    }
    public static String morsToAlfabe(String morseCode) {
        StringBuilder builder = new StringBuilder();
        String[] words = morseCode.trim().split("  ");

        for (String word : words) {
            for (String letter : word.split(" ")) {
                String alpha = MORS_TO_ALFABE.get(letter);
                builder.append(alpha);
            }
            builder.append(" ");

        }
        return builder.toString().toUpperCase();
    }
    public static String alfabeToMors(String turkceCode){
        StringBuilder builder = new StringBuilder();
        String[] words = turkceCode.trim().split(" ");

        for (String word : words){
            for (int i = 0; i < word.length(); i++){
                String mors = ALFABE_TO_MORS.get(word.substring(i,i+1).toLowerCase());
                builder.append(mors).append(" ");
            }
            builder.append(" ");
        }
        return builder.toString();
    }
}

