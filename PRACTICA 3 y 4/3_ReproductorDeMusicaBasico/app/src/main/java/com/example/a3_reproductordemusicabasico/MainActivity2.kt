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

class MainActivity2 : AppCompatActivity() {
    private lateinit var mediaPlayerList: List<MediaPlayer>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        var posicion = 0
        var repetir = false

        val imgFront = findViewById<ImageView>(R.id.imageView)
        val txtTitulo = findViewById<TextView>(R.id.txt_titulo)

        val playPause = findViewById<ImageButton>(R.id.btn_play)
        val btnRepetir = findViewById<ImageButton>(R.id.btn_repetir)
        val btnStop = findViewById<ImageButton>(R.id.btn_detener)
        val btnAnterior = findViewById<ImageButton>(R.id.btn_anterior)
        val btnSiguiente = findViewById<ImageButton>(R.id.btn_siguiente)

        // Creamos la lista de reproducción
        fun inicializarMediaPLayer() {
            mediaPlayerList = listOf(
                MediaPlayer.create(this, R.raw.creep),
                MediaPlayer.create(this, R.raw.cumbia),
                MediaPlayer.create(this, R.raw.foster),
                MediaPlayer.create(this, R.raw.head),
                MediaPlayer.create(this, R.raw.paredon)
            )
        }

        inicializarMediaPLayer() // Inicializamos por primera vez la lista de reproducción.

        fun actualizarInterfaz() {
            val (imagen, titulo) = when (posicion) {
                0 -> Pair(R.drawable.creep_port, R.string.txt_creep)
                1 -> Pair(R.drawable.cumbia_port, R.string.txt_cumbia)
                2 -> Pair(R.drawable.foster_port, R.string.txt_foster)
                3 -> Pair(R.drawable.foster_port, R.string.txt)
                else -> Pair(R.drawable.foster_port, R.string.txt_foster)
            }
            imgFront.setImageResource(imagen)
            txtTitulo.setText(titulo)
            playPause.setImageResource(R.drawable.boton_de_pausa)
        }

        // Método para el boton PLAY & PAUSE
        playPause.setOnClickListener {
            if (mediaPlayerList[posicion].isPlaying) {
                mediaPlayerList[posicion].pause()
                playPause.setImageResource(R.drawable.boton_de_play)
                Toast.makeText(this, " Pause", Toast.LENGTH_SHORT).show()
            } else {
                mediaPlayerList[posicion].start()
                playPause.setImageResource(R.drawable.boton_de_pausa)
                Toast.makeText(this, "   Play", Toast.LENGTH_SHORT).show()
            }
        }

        // Método para el boton DETENER
        btnStop.setOnClickListener {
            mediaPlayerList[posicion].stop()
            posicion = 0
            inicializarMediaPLayer()
            actualizarInterfaz()
            playPause.setImageResource(R.drawable.boton_de_play)
            Toast.makeText(this, "   Stop", Toast.LENGTH_SHORT).show()
        }

        // Método para el boton REPETIR
        btnRepetir.setOnClickListener {
            if (repetir) {
                btnRepetir.setImageResource(R.drawable.repetir)
                Toast.makeText(this, "No repetir", Toast.LENGTH_SHORT).show()
                mediaPlayerList[posicion].isLooping = false
                repetir = false
            } else {
                btnRepetir.setImageResource(R.drawable.repetir2)
                Toast.makeText(this, "Repetir", Toast.LENGTH_SHORT).show()
                mediaPlayerList[posicion].isLooping = true
                repetir = true
            }
        }

        // Método para el boton SIGUIENTE
        btnSiguiente.setOnClickListener {
            if (posicion < mediaPlayerList.size - 1) {
                mediaPlayerList[posicion].stop()
                posicion++
                mediaPlayerList[posicion].start()
                actualizarInterfaz()
            } else {
                Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show()
            }
        }

        // Método para el boton ANTERIOR
        btnAnterior.setOnClickListener {
            if (posicion >= 1) {
                mediaPlayerList[posicion].stop()
                mediaPlayerList[posicion].prepareAsync()
                posicion--
                mediaPlayerList[posicion].prepare()
                mediaPlayerList[posicion].start()
                actualizarInterfaz()

            } else {
                Toast.makeText(this, "No hay mas canciones", Toast.LENGTH_SHORT).show()
            }
        }

    }

}