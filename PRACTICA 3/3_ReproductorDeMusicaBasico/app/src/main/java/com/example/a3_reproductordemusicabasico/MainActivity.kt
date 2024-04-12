package com.example.a3_reproductordemusicabasico

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * @problemDescription Se solicita, crear un reproductor de musica basico que contenga:
 * reproducir, pausar y detener la musica local.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 09/04/24
 * @lastModification 09/04/24
 */

class MainActivity : AppCompatActivity() {
    private lateinit var mediaPlayerList: List<MediaPlayer>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val play_pause = findViewById<ImageButton>(R.id.btn_play)
        val posicion = 0
        val iv = findViewById<ImageView>(R.id.imageView)

        mediaPlayerList = listOf(
            MediaPlayer.create(this, R.raw.creep),
            MediaPlayer.create(this, R.raw.cumbia),
            MediaPlayer.create(this, R.raw.foster)
        )


        play_pause.setOnClickListener() {
            if (mediaPlayerList[posicion].isPlaying()) {
                mediaPlayerList[posicion].pause()
                play_pause.setImageResource(R.drawable.boton_de_play)
                Toast.makeText(this, "Pausa", Toast.LENGTH_SHORT).show()
            } else {
                mediaPlayerList[posicion].start()
                play_pause.setImageResource(R.drawable.boton_de_pausa)
                Toast.makeText(this, "Play", Toast.LENGTH_SHORT).show()
            }
        }
    }

}