package com.example.a2_calculadorabasica

import android.annotation.SuppressLint
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

    lateinit var txtInput: TextView
    lateinit var txtOutput: TextView
    var exp1 = ""
    var exp2 = ""
    var operator = ""
    var isNewExp = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        txtInput = findViewById<TextView>(R.id.txt_input)
        txtOutput = findViewById<TextView>(R.id.txt_output)
    }

    fun onButtonClick(view: View) {
        val buttonText = (view as Button).text.toString()

        when (buttonText) {
            "=" -> txtOutput.text = eval().toString()
            in "+-*/" -> {}
            // Para los numeros
            else -> {
                if (exp2Enable == true) {
                    val exp2SinCeros = (exp2.toString() + buttonText).trimStart('0')
                    exp2 = exp2SinCeros.toInt()
                    txtInput.text = currentInput + buttonText
                } else {
                    txtInput.text = currentInput + buttonText
                }
            }

        }

    }


    private fun setOperator(operator: String) {
        this.operator = operator
        isNewExp = true
        exp1 = textView.text.toString()
    }
    fun eval(): Double {
        val num1 = exp1.toDouble()
        val num2 = exp2.toDouble()

        return when(operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            else -> num1 / num2
        }
    }
}



