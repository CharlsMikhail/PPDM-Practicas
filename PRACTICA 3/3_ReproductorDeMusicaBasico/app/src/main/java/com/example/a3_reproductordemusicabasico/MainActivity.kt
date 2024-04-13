package com.example.a3_reproductordemusicabasico

import android.media.MediaPlayer
import android.os.Bundle
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
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

        var posicion = 0
        var repetir = 0

        val imgFront = findViewById<ImageView>(R.id.imageView)
        val txt_titulo = findViewById<TextView>(R.id.txt_titulo)

        val play_pause = findViewById<ImageButton>(R.id.btn_play)
        val btn_repetir = findViewById<ImageButton>(R.id.btn_repetir)
        val btn_stop = findViewById<ImageButton>(R.id.btn_detener)
        val btn_anterior = findViewById<ImageButton>(R.id.btn_anterior)
        val btn_siguiente = findViewById<ImageButton>(R.id.btn_siguiente)

        // Creamos la lista de reporduccion
        mediaPlayerList = listOf(
            MediaPlayer.create(this, R.raw.creep),
            MediaPlayer.create(this, R.raw.cumbia),
            MediaPlayer.create(this, R.raw.foster)
        )

        // Método para el boton PLAY & PAUSE
        play_pause.setOnClickListener() {
            if (mediaPlayerList[posicion].isPlaying) {
                mediaPlayerList[posicion].pause()
                play_pause.setImageResource(R.drawable.boton_de_play)
                Toast.makeText(this, " Pause", Toast.LENGTH_SHORT).show()
            } else {
                mediaPlayerList[posicion].start()
                play_pause.setImageResource(R.drawable.boton_de_pausa)
                Toast.makeText(this, "   Play", Toast.LENGTH_SHORT).show()
            }
        }

        // Método para el boton DETENER
        btn_stop.setOnClickListener() {
            mediaPlayerList[posicion].stop()
            mediaPlayerList = listOf(
                MediaPlayer.create(this, R.raw.creep),
                MediaPlayer.create(this, R.raw.cumbia),
                MediaPlayer.create(this, R.raw.foster)
            )
            posicion = 0
            play_pause.setImageResource(R.drawable.boton_de_play)
            imgFront.setImageResource(R.drawable.creep_port)
            txt_titulo.setText(R.string.txt_creep)
            Toast.makeText(this, "   Stop", Toast.LENGTH_SHORT).show()
        }

        btn_repetir.setOnClickListener() {
            if (repetir == 1) {
                btn_repetir.setImageResource(R.drawable.repetir)
                Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show()
                mediaPlayerList[posicion].isLooping = false
                repetir = 2
            } else {
                btn_repetir.setImageResource(R.drawable.repetir2)
                Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show()
                mediaPlayerList[posicion].isLooping = true
                repetir = 1
            }
        }

        btn_siguiente.setOnClickListener() {
            if (posicion < mediaPlayerList.size - 1) {
                if (mediaPlayerList[posicion].isPlaying()) {
                    mediaPlayerList[posicion].stop();
                    posicion++
                    mediaPlayerList[posicion].start()
                } else {
                    posicion ++
                }
                when(posicion) {
                    0 -> {imgFront.setImageResource(R.drawable.creep_port)
                        txt_titulo.setText(R.string.txt_creep)
                    }
                    1 -> {imgFront.setImageResource(R.drawable.cumbia_port)
                        txt_titulo.setText(R.string.txt_cumbia)
                    }
                    else -> {
                        imgFront.setImageResource(R.drawable.foster_port)
                        txt_titulo.setText(R.string.txt_foster)
                    }
                }
            } else {
                Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show()
            }
        }

        btn_anterior.setOnClickListener() {
            if (posicion >= 1) {
                if (mediaPlayerList[posicion].isPlaying()) {
                    mediaPlayerList[posicion].stop();
                    mediaPlayerList = listOf(
                        MediaPlayer.create(this, R.raw.creep),
                        MediaPlayer.create(this, R.raw.cumbia),
                        MediaPlayer.create(this, R.raw.foster)
                    )
                    posicion--
                    mediaPlayerList[posicion].start()
                } else {
                    posicion --
                }
                when(posicion) {
                    0 -> {imgFront.setImageResource(R.drawable.creep_port)
                        txt_titulo.setText(R.string.txt_creep)
                    }
                    1 -> {imgFront.setImageResource(R.drawable.cumbia_port)
                        txt_titulo.setText(R.string.txt_cumbia)
                    }
                    else -> {
                        imgFront.setImageResource(R.drawable.foster_port)
                        txt_titulo.setText(R.string.txt_foster)
                    }
                }
            } else {
                Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show()
            }
        }

    }

}