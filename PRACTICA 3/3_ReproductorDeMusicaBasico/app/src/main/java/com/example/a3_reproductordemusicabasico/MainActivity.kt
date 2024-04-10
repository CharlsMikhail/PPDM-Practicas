package com.example.a3_reproductordemusicabasico

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @problemDescription Se solicita, crear un reproductor de musica basico que contenga:
 * reproducir, pausar y detener la musica local.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 09/04/24
 * @lastModification 09/04/24
 */

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}