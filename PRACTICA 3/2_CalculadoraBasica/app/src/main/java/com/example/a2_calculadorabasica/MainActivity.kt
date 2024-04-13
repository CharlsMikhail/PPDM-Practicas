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
    var exp1 = 0.0
    var exp2 = 0.0
    var operator = ""
    var exp2String = ""
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
            "=" -> txtOutput.append(eval().toString())
            in "+-*/" -> setOperator(buttonText)
            // Para los números
            else -> appendOperand(buttonText)
        }
    }

    private fun appendOperand(digit: String) {
        if (isNewExp) exp2String += digit
        txtInput.append(digit)
    }

    private fun setOperator(operator: String) {
        this.operator = operator
        isNewExp = true
        exp1 = txtInput.text.toString().toDouble()
        txtInput.append(this.operator)
    }

    fun eval(): Double {
        exp2 = exp2String.toDouble()
        isNewExp = false
        return when(operator) {
            "+" -> exp1 + exp2
            "-" -> exp1 - exp2
            "*" -> exp1 * exp2
            else -> exp1 / exp2
        }
    }
}



