package com.example.a1_interaccionconimagenes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity



class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        // Recupero las información de la actividad 1
        val mensaje = intent.getStringExtra(KEY_TEXT)
        val imgSelected = intent.getStringExtra(KEY_IMG)

        val imgMain = findViewById<ImageButton>(R.id.imgb_main)

        imgMain.setImageResource(
            when (imgSelected) {
                "imagen1" -> R.drawable.imagen1
                "imagen2" -> R.drawable.imagen2
                "imagen3" -> R.drawable.imagen3
                else -> {TODO("EXCEPTIONS")}
            }
        )

        imgMain.setOnClickListener {
            Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
        }

        val btnBack = findViewById<Button>(R.id.btn_return)

        btnBack.setOnClickListener {
            // Empaquetamos antes de volver, apra poder recuperar la información.
            val intent = Intent()
            intent.putExtra(KEY_TEXT, mensaje)
            intent.putExtra(KEY_IMG, imgSelected)
            setResult(Activity.RESULT_OK, intent)

            finish()
        }
    }
}