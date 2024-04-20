package com.example.a3_reproductordemusicabasico

import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * @problemDescription PC3 - Se solicita, crear un reproductor de musica básico que contenga:
 * reproducir, pausar y detener musica.
 * @problemDescription PC4 - Se solicita, agregar una "Actividad" de menú antes de reproducir una musica.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 09/04/24
 * @lastModification 20/04/24
 */

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayerList: List<MediaPlayer>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

    }

}