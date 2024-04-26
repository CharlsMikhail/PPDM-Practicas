package com.example.a2_reproductordemusicav3

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

/**
 * @problemDescription Se solicita, crear un reproductor de musica básico que contenga:
 * reproducir, pausar y detener musica. Usando fragmentos.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 26/04/24
 * @lastModification 26/04/24
 */
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportFragmentManager.beginTransaction().apply {
            setReorderingAllowed(true)
            add(R.id.menuMusicFragment, MenuMusicFragment())
            commit()
        }
    }
}