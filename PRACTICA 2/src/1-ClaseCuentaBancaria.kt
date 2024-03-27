/**
 * @problemDescription Se solicita el diseño de la clase "CuentaBancaria" que tenga un saldo y un limite de retiro,
 * tambien usar métodos get y set hacer validaciones.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 23/03/24
 * @lastModification 26/03/24
 */

class CuentaBancaria(saldo: Float, private var limiteRetiro: Float) {
    private var saldo: Float = saldo
        set(value) {
            // Se verifica que el saldo sea positivo antes de actualizarlo.
            if (value >= 0) {
                field = value
                println("Operación realizado con éxito. Nuevo saldo: $saldo")
            }
            else
                println("Error, fondos insuficientes para realizar el retiro.")
        }
        //  No tenemos alguna modificación que hacer para reeescribir el get(), estariamos redundando.
        get() = field

    fun realizarRetiro(montoRetiro: Float) {
        // Se verifica si el monto a retirar excede el límite establecido.
        when {
            montoRetiro < 0 -> println("Error, el monto de retiro no puede ser negativo")
            montoRetiro > limiteRetiro -> println("Error, el monto a retirar supera el límite de retiro.")
            else -> saldo -= montoRetiro
        }
    }

    fun imprimirSaldo() {
        println("Saldo actual: $saldo")
    }
}

fun main() {
    val cuenta = CuentaBancaria(1200F, 500F)
    // Probamos el funcionamiento de la función realizarRetiro() con distintos montos de retiro.
    cuenta.imprimirSaldo()
    cuenta.realizarRetiro(500F)
    cuenta.realizarRetiro(800F)
    cuenta.realizarRetiro(500F)
    cuenta.realizarRetiro(300F)
    cuenta.imprimirSaldo()
}
