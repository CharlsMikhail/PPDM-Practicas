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

    var exp1: Int = 0
    var exp2: Int = 0
    var exp2Enable = false
    var operator = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    @SuppressLint("SetTextI18n")
    fun onButtonClick(view: View) {

        val buttonText = (view as Button).text.toString()
        val txtInput = findViewById<TextView>(R.id.txt_input)
        val txtOutput = findViewById<TextView>(R.id.txt_output)
        if (txtOutput.text.length > 2) {
            exp1 = 0
            exp2 = 0
            exp2Enable = false
            operator = ""
            txtInput.text = ""
            txtOutput.text = "="
        }

        val currentInput = txtInput.text.toString()


        when (buttonText) {
            in "0123456789" -> {
                if (exp2Enable == true) {
                    val exp2SinCeros = (exp2.toString() + buttonText).trimStart('0')
                    exp2 = exp2SinCeros.toInt()
                    txtInput.text = currentInput + buttonText
                } else {
                    txtInput.text = currentInput + buttonText
                }
            }
            in "+-*/" -> {
                val currentText = txtInput.text.toString()
                val newText = currentText + buttonText
                exp1 = currentText.toInt()
                txtInput.text = newText
                operator = "+"
                exp2Enable = true
            }
            "=" -> {
                val result = eval(exp1, exp2, operator)
                txtOutput.text = "= $result"
            }
        }
    }

    fun eval(num1: Int, num2: Int, operator: String): Int {
        return when(operator) {
            "+" -> num1 + num2
            "-" -> num1 - num2
            "*" -> num1 * num2
            else -> num1 / num2
        }
    }
}



