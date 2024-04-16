package com.example.a1_interaccionconimagenes

import android.os.Bundle
import android.widget.EditText
import android.widget.ImageButton
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
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val txtCustom = findViewById<EditText>(R.id.txt_custom)
        val imgBPicture = findViewById<ImageButton>(R.id.imgb_main)
        imgBPicture.setOnClickListener {
            val msg = txtCustom.text
            if (msg.isNotEmpty()) {
                Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
            } else {
                Toast.makeText(this, "Acabas de darle click a la imagen", Toast.LENGTH_SHORT).show()
            }
        }
    }
}