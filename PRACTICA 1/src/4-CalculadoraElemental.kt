import kotlin.system.exitProcess

/**
 * @problemDescription Se solicita una calculadora basica(+, -, *, /) que tenga como interfaz un menú en consola.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 16/03/24
 * @lastModification ?
 */

fun realizarOperacion(operador: String): Double {
    println("Ingrese dos números a operar:")
    print("#1 => ")
    val num1: Double = readln().toDouble()
    print("#2 => ")
    val num2: Double = readln().toDouble()

    return when(operador) {
        "+" -> {num1 + num2}
        "-" -> {num1 - num2}
        "*" -> {num1 * num2}
        "/" -> {num1 / num2}
        else -> -1.0
    }
}

fun ejecutarOpcion(opc: Int) {
    when (opc) {
        1 -> {println("\n\tnSUMA")
            println("Resultado: ${realizarOperacion("+")}")
            mostrarMenu()}
        2 -> {println("\n\tRESTA")
            println("Resultado: ${realizarOperacion("-")}")
            mostrarMenu()}
        3 -> {println("\n\tMULTIPLICACIÓN")
            println("Resultado: ${realizarOperacion("*")}")
            mostrarMenu()}
        4 -> {println("\n\tDIVICIÓN")
            println("Resultado: ${realizarOperacion("/")}")
            mostrarMenu()}
        5 -> {println("Se salio de la caluladora!")
            exitProcess(1)}
        else -> {println("Error, elija una opcion valida(1-5)")
                mostrarMenu()}
    }
}
fun mostrarMenu() {
    println("\n===== MENÚ =====\n 1. Suma\n 2. Resta\n 3. Multiplicación\n 4. Divición\n 5. Salir")
    print("Opcion: ")
    val opc: Int = readln().toInt()
    ejecutarOpcion(opc)
}
fun main() {
    mostrarMenu()
}