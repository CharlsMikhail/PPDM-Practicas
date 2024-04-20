package com.example.a3_reproductordemusicabasico

import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity

/**
 * @problemDescription PC3 - Se solicita, crear un reproductor de musica básico que contenga:
 * reproducir, pausar y detener musica.
 * @problemDescription PC4 - Se solicita, agregar una "Actividad" de menú antes de reproducir una musica.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 09/04/24
 * @lastModification 20/04/24
 */

const val KEY_SELECT = "select"

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val spnMusic = findViewById<Spinner>(R.id.spn_music)
        val btnSelect = findViewById<Button>(R.id.btn_select)

        // Configuramos el sipinner con la lista de músicas
        val options = listOf("1. Creep", "2. Cumbia Boliviana", "3. Pumped Up Kicks", "4. In My Head", "5. Paredon" )
        val adapter = ArrayAdapter(this, R.layout.spinner_item_custom, options)
        spnMusic.adapter = adapter

        btnSelect.setOnClickListener {
            // Preparamos el cambio de actividad
            val selected = spnMusic.selectedItemPosition

            // Creamos el intent() para guardar y despúes recueprar en la otra actividad
            val intent = Intent(this, MainActivity2::class.java)
            intent.putExtra(KEY_SELECT, selected)

            startActivity(intent)
        }

    }

}