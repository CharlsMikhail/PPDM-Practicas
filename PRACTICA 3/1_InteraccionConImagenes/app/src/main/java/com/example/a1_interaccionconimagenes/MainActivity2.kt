package com.example.a1_interaccionconimagenes

import android.os.Bundle
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity



class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Recupero las información de la actividad 1
        val txt = intent.getStringExtra(KEY_TEXT)
        val imgSelected = intent.getStringExtra(KEY_IMG)

        val imgMain = findViewById<ImageButton>(R.id.imgb_main)
        when (imgSelected) {
            "imagen1" ->
        }



    }
}