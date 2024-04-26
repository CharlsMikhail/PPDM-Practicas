package com.example.a2_reproductordemusicav3

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.View
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf

class ReproductorFragment : Fragment(R.layout.fragment_reproductor) {
    private lateinit var mediaPlayerList: List<MediaPlayer>

    private var mscSelected: Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mscSelected = requireArguments().getInt(KEY_MSC)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        var posicion = mscSelected
        var repetir = false

        val imgFront = view.findViewById<ImageView>(R.id.imageView)
        val txtTitulo = view.findViewById<TextView>(R.id.txt_titulo)

        val playPause = view.findViewById<ImageButton>(R.id.btn_play)
        val btnRepetir = view.findViewById<ImageButton>(R.id.btn_repetir)
        val btnStop = view.findViewById<ImageButton>(R.id.btn_detener)
        val btnAnterior = view.findViewById<ImageButton>(R.id.btn_anterior)
        val btnSiguiente = view.findViewById<ImageButton>(R.id.btn_siguiente)

        fun actualizarInterfaz() {
            val (imagen, titulo) = when (posicion) {
                0 -> Pair(R.drawable.creep_port, R.string.txt_creep)
                1 -> Pair(R.drawable.cumbia_port, R.string.txt_cumbia)
                2 -> Pair(R.drawable.foster_port, R.string.txt_foster)
                3 -> Pair(R.drawable.head_port, R.string.txt_head)
                else -> Pair(R.drawable.paredon_port, R.string.txt_paredon)
            }
            imgFront.setImageResource(imagen)
            txtTitulo.setText(titulo)
            playPause.setImageResource(R.drawable.boton_de_pausa)
        }

        inicializarMediaPLayer() // Inicializamos por primera vez la lista de reproducción.
        actualizarInterfaz() // Actualizamos la interfaz por primera vez
        playPause.setImageResource(R.drawable.boton_de_play)

        // Método para el boton PLAY & PAUSE
        playPause.setOnClickListener {
            if (mediaPlayerList[posicion].isPlaying) {
                mediaPlayerList[posicion].pause()
                playPause.setImageResource(R.drawable.boton_de_play)
                Toast.makeText(requireContext(), getString(R.string.txt_play), Toast.LENGTH_SHORT).show()
            } else {
                mediaPlayerList[posicion].start()
                playPause.setImageResource(R.drawable.boton_de_pausa)
                Toast.makeText(requireContext(), getString(R.string.txt_play), Toast.LENGTH_SHORT).show()
            }
        }

        // Método para el boton DETENER
        btnStop.setOnClickListener {
            mediaPlayerList[posicion].stop()
            posicion = 0
            inicializarMediaPLayer()
            actualizarInterfaz()
            playPause.setImageResource(R.drawable.boton_de_play)
            Toast.makeText(requireContext(), getString(R.string.txt_stop), Toast.LENGTH_SHORT).show()
        }

        // Método para el boton REPETIR
        btnRepetir.setOnClickListener {
            if (repetir) {
                btnRepetir.setImageResource(R.drawable.repetir)
                Toast.makeText(requireContext(), getString(R.string.txt_no_repetir), Toast.LENGTH_SHORT).show()
                mediaPlayerList[posicion].isLooping = false
                repetir = false
            } else {
                btnRepetir.setImageResource(R.drawable.repetir2)
                Toast.makeText(requireContext(), getString(R.string.txt_repetir), Toast.LENGTH_SHORT).show()
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
                Toast.makeText(requireContext(), getString(R.string.txt_no_canciones), Toast.LENGTH_SHORT).show()
            }
        }

        // Método para el boton ANTERIOR
        btnAnterior.setOnClickListener {
            if (posicion >= 1) {
                mediaPlayerList[posicion].stop()
                mediaPlayerList[posicion].prepareAsync()
                posicion--
                try { mediaPlayerList[posicion].prepare() } catch (_:Exception) {}
                mediaPlayerList[posicion].start()
                actualizarInterfaz()

            } else {
                Toast.makeText(requireContext(), getString(R.string.txt_no_canciones), Toast.LENGTH_SHORT).show()
            }
        }
    }
    private fun inicializarMediaPLayer() {
        mediaPlayerList = listOf(
            MediaPlayer.create(requireContext(), R.raw.creep),
            MediaPlayer.create(requireContext(), R.raw.cumbia),
            MediaPlayer.create(requireContext(), R.raw.foster),
            MediaPlayer.create(requireContext(), R.raw.head),
            MediaPlayer.create(requireContext(), R.raw.paredon)
        )
    }

    // Para que el sonido tambien se destruya.
    override fun onDestroy() {
        super.onDestroy()
        mediaPlayerList.forEach { mediaPlayer ->
            mediaPlayer.stop()
            mediaPlayer.release()
        }
        requireActivity().supportFragmentManager.setFragmentResult(REQUEST_CODE, bundleOf(
            KEY_MSG to getString(R.string.txt_volvimos))
        )
        requireActivity().supportFragmentManager.popBackStack()
        //Log.d("CicloVida2", "Método destroy")
    }

    companion object {
        // Fun para pasar información
        fun newInstance(mscSelected: Int) = ReproductorFragment().apply {

            // 1ra forma
            val datos = Bundle()
            datos.putInt(KEY_MSC, mscSelected)
            arguments = datos

            // 2da forma
            //arguments.bundleOf(MI_NOMBRE to nombre, MI_EDAD to edad)
        }
    }
}