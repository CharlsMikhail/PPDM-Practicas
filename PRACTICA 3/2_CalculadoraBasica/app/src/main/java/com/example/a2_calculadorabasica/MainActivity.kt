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
 * @lastModification 12/04/24
 */

class MainActivity : AppCompatActivity() {

    private lateinit var txtInput: TextView
    private lateinit var txtOutput: TextView

    private var exp1 = 0.0
    private var exp2 = 0.0
    private var operator = ""
    private var exp2String = ""
    private var isNewExp = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        txtInput = findViewById(R.id.txt_input)
        txtOutput = findViewById(R.id.txt_output)

        setButtonsEnabled(false)
    }

    fun onButtonClick(view: View) {
        when (val buttonText = (view as Button).text.toString()) {
            "=" -> txtOutput.append(eval().toString())
            in "+-*/" -> setOper(buttonText)
            else -> appendExp(buttonText) // Para los botones del 0 al 9
        }
    }

    // Agregar más digitos a la expresión actual
    private fun appendExp(digit: String) {
        if (isNewExp) exp2String += digit
        if (!txtOutput.text.isNullOrEmpty()) { // Para restaurar valores y limpiar la interfaz.
            txtInput.text = ""
            txtOutput.text = ""
            exp2String = ""
            setButtonsEnabled(true)
        }
        txtInput.append(digit)
        setButtonsEnabled(true)
    }

    // Se hace el cambio de expresión, o sea de la exp1 a exp2(para almacenar exp2).
    private fun setOper(operator: String) {
        this.operator = operator
        isNewExp = true
        exp1 = txtInput.text.toString().toDouble()
        txtInput.append(this.operator)
    }

    // Dependiendo del operador se realiza la operacion correspondiente.
    private fun eval(): Double {
        exp2 = exp2String.toDouble()
        isNewExp = false

        setButtonsEnabled(false) // Para evitar errores.

        return when(operator) {
            "+" -> exp1 + exp2
            "-" -> exp1 - exp2
            "*" -> exp1 * exp2
            else -> exp1 / exp2
        }
    }

    private fun setButtonsEnabled(enabled: Boolean) {
        val btnEqual = findViewById<Button>(R.id.btn_equal)
        val btnAdd = findViewById<Button>(R.id.btn_sum)
        val btnSub = findViewById<Button>(R.id.btn_res)
        val btnMul = findViewById<Button>(R.id.btn_mul)
        val btnDiv = findViewById<Button>(R.id.btn_div)
        val btnZero = findViewById<Button>(R.id.btn_0)

        btnEqual.isEnabled = enabled
        btnAdd.isEnabled = enabled
        btnSub.isEnabled = enabled
        btnMul.isEnabled = enabled
        btnDiv.isEnabled = enabled
        btnZero.isEnabled = enabled
    }

}



