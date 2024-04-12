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

    private val play_pause : ImageButton? = null
    private val boton_repetir: ImageButton? = null
    private val mediaPlayer: MediaPlayer? = null
    private val imagenView: ImageView? = null
    private val repetir = 2
    private val posicion = 0

    private val mediaPlayerArray = Array<MediaPlayer?>(3) { null }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val play_pause = findViewById<ImageButton>(R.id.btn_play)

        val iv = findViewById<ImageView>(R.id.imageView)

        mediaPlayerArray[0] = MediaPlayer.create(this, R.raw.creep);
        mediaPlayerArray[1] = MediaPlayer.create(this, R.raw.cumbia);
        mediaPlayerArray[2] = MediaPlayer.create(this, R.raw.foster);
    }

    fun playPause(view: View) {
        if (mediaPlayerArray[posicion]?.isPlaying() == true) {
            mediaPlayerArray[posicion]?.pause()
            play_pause?.setBackgroundResource(R.drawable.boton_de_pausa)
            Toast
        } else {

        }
    }

}