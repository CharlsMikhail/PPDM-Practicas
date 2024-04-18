package com.example.a1_interaccionconimagenes

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.Spinner
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

/**
 * @problemDescription PC3 - Se solicita, mostrar una imagen, al presionar la imagen: se muestre
 * en pantalla un mensaje personalizado usando Toast, el mensaje se saca de un EditText.
 * @problemDescription PC4 - Se solicita, agregar un Spinner para poder seleccionar más imagenes
 * , implentar otra actividad; ambas no tienen que perder información de una a la otra, estas
 * actividades se comunican con botones, "siguiente" y "volver".
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 09/04/24
 * @lastModification 16/04/24
 */

class MainActivity : AppCompatActivity() {

    val KEY_TEXT = "text"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtCustom = findViewById<EditText>(R.id.txt_custom)
        val spnImages = findViewById<Spinner>(R.id.spn_images)
        val btnSelect = findViewById<Button>(R.id.btn_select)

        val opciones = listOf("Imagen1", "Imagen2", "Imagen3")

        // Preparamos el cambio de actividad
        val msg = txtCustom.text


        val intent = Intent(this, MainActivity2::class.java)



        intent.putExtra(KEY_TEXT, msg)


        btnSelect.setOnClickListener {

        }


    }
}