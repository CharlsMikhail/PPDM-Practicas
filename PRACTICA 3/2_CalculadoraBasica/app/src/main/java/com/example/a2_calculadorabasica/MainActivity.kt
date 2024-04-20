package com.example.a2_calculadorabasica

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

/**
 * @problemDescription PC3 - Se solicita, crear una calculadora básica, que sume, reste, multplique
 * y divida; la interacción se muestre en un TextView.
 * @problemDescription PC4 - Se solicita, agregar funcionalidad para que al voltear horizontalmente
 * el dispositivo no se pierda la inforamación.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 09/04/24
 * @lastModification 20/04/24
 */

class MainActivity : AppCompatActivity() {

    private lateinit var txtInput: TextView
    private lateinit var txtOutput: TextView
    private lateinit var btnEqual: Button

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
        btnEqual = findViewById(R.id.btn_equal)

        btnEqual.isEnabled = false
        setButtonsEnabled(false)
    }

    fun onButtonClick(view: View) {
        when (val buttonText = (view as Button).text.toString()) {
            "=" -> txtOutput.append("= " + eval().toString())
            in "+-*/" -> setOper(buttonText)
            else -> appendExp(buttonText) // Para los botones del 0 al 9
        }
    }

    // Agregar más digitos a la expresión actual.
    private fun appendExp(digit: String) {
        if (isNewExp) exp2String += digit
        if (exp2String.isNotEmpty()) btnEqual.isEnabled = true // Aaeguramos que exp2 tenga digitos.
        if (!txtOutput.text.isNullOrEmpty()) { // Para restaurar valores y limpiar la interfaz.
            txtInput.text = ""
            txtOutput.text = ""
            setButtonsEnabled(true)
        }
        if (txtInput.text.isNullOrEmpty()) setButtonsEnabled(true)
        txtInput.append(digit)
    }

    // Se hace el cambio de expresión, o sea de la exp1 a exp2(para almacenar exp2).
    private fun setOper(operator: String) {
        this.operator = operator
        isNewExp = true
        exp1 = txtInput.text.toString().toDouble() // Expresion 1 ya tiene valor
        txtInput.append(this.operator)
        setButtonsEnabled(false) // Para evitar errores.
    }

    // Dependiendo del operador se realiza la operacion correspondiente.
    private fun eval(): Double {
        exp2 = exp2String.toDouble()
        isNewExp = false

        exp2String = ""
        btnEqual.isEnabled = false

        return when(operator) {
            "+" -> exp1 + exp2
            "-" -> exp1 - exp2
            "*" -> exp1 * exp2
            else -> exp1 / exp2
        }
    }

    // Para habilitar o deshabilitar los botones de tal manera no causen errores.
    private fun setButtonsEnabled(enabled: Boolean) {
        val btnAdd = findViewById<Button>(R.id.btn_sum)
        val btnSub = findViewById<Button>(R.id.btn_res)
        val btnMul = findViewById<Button>(R.id.btn_mul)
        val btnDiv = findViewById<Button>(R.id.btn_div)

        btnAdd.isEnabled = enabled
        btnSub.isEnabled = enabled
        btnMul.isEnabled = enabled
        btnDiv.isEnabled = enabled
    }

}



