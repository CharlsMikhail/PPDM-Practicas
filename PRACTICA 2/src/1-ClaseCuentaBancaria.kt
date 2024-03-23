/**
 * @problemDescription Se solicita el diseño de la clase "CuentaBancaria" que tenga un saldo y un limite de retiro,
 * tambien usar métodos get y set hacer validaciones.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 23/03/24
 * @lastModification ?
 */

class CuentaBancaria(saldo: Float, var limiteRetiro: Float) {

    var saldo: Float = saldo
        set(saldoNuevo) {
            // Validamos que el saldo sea positivo.
            if (saldoNuevo >= 0)
                field = saldoNuevo
            else
                println("Error, no se puede establecer un saldo negativo")
        }
        get() {
            return field
        }
    fun realizarRetiro(montoRetiro: Float) {
        // Validamos que el retiro no osbre pase el limite de retiro establecido.
        if (montoRetiro > limiteRetiro) {
            println("Error, el monto a retirar sobrepasa el limite de retiro.")
        } else {
            saldo -= montoRetiro
        }
    }
}

fun main() {
    val cuenta = CuentaBancaria(1200F, 500F)
    println("Saldo actual: ${cuenta.saldo}")

    // Probamos el correcto funcionamiento de nuestro diseño.
    cuenta.realizarRetiro(500F)
    println("Saldo actual: ${cuenta.saldo}")

    cuenta.realizarRetiro(800F)
    println("Saldo actual: ${cuenta.saldo}")

    cuenta.realizarRetiro(500F)
    println("Saldo actual: ${cuenta.saldo}")

    cuenta.realizarRetiro(300F)
    println("Saldo actual: ${cuenta.saldo}")
}
