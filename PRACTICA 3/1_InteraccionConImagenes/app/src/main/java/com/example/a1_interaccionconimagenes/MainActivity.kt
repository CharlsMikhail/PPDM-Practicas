package com.example.a1_interaccionconimagenes

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.ArrayAdapter
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

const val REQUEST_CODE = 123
private const val KEY_TEXT = "text"
private const val KEY_IMG = "image"

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtCustom = findViewById<EditText>(R.id.txt_custom)
        val spnImages = findViewById<Spinner>(R.id.spn_images)
        val btnSelect = findViewById<Button>(R.id.btn_select)

        val opciones = listOf("Imagen1", "Imagen2", "Imagen3")

        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, opciones)
        spnImages.adapter = adapter

        // Preparamos el cambio de actividad
        val msg = txtCustom.text.toString()
        val selected = spnImages.selectedItem.toString()

        // Creamos el intent() para guardar y despúes recueprar en la otra actividad
        val intent = Intent(this, MainActivity2::class.java)
        intent.putExtra(KEY_TEXT, msg)
        intent.putExtra(KEY_IMG, selected)


        btnSelect.setOnClickListener {
            startActivityForResult(intent, REQUEST_CODE)
        }


    }




    // Forma antigua
    @Deprecated("Deprecated in Java")
    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == REQUEST_CODE ) {
            if (resultCode == Activity.RESULT_OK) {
                val res = data?.getIntExtra(KEY_INT, 0).toString()
                Toast.makeText(this, res, Toast.LENGTH_LONG).show()
            }
        }
    }
}



