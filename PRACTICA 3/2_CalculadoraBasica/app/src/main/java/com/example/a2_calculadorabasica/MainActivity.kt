package com.example.a2_calculadorabasica

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


/**
 * @problemDescription Se solicita, crear una calculadora básica, que sume, reste, multplique
 * y divida la interacción se muestre en un un TextView.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 09/04/24
 * @lastModification 09/04/24
 */

class MainActivity : AppCompatActivity() {

    var exp1 = false
    var exp2 = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onButtonClick(view: View) {
        val buttonText = (view as Button).text.toString()
        val txtInput = findViewById<TextView>(R.id.txt_input)
        val txtOutput = findViewById<TextView>(R.id.txt_output)
        val currentInput = txtInput.text.toString()

        when (buttonText) {
            in "0123456789" -> {
                txtInput.text = currentInput + buttonText
            }
            "+" -> {
                exp1 = true
                val currentText = txtInput.text.toString()
                val newText = currentText + buttonText
                txtInput.text = newText
            }
            "-" -> {
                val currentText = txtInput.text.toString()
                val newText = currentText + buttonText
                txtInput.text = newText
            }
            "*" -> {
                val currentText = txtInput.text.toString()
                val newText = currentText + buttonText
                txtInput.text = newText
            }
            "/" -> {
                val currentText = txtInput.text.toString()
                val newText = currentText + buttonText
                txtInput.text = newText
            }
            "=" -> {
                val expression = txtInput.text.toString()
                val result = 1 + 1
                txtOutput.text = "= $result"
                txtInput.text = ""
            }
        }
    }
}



