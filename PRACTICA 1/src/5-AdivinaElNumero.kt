import kotlin.random.Random
import kotlin.system.exitProcess

/**
 * @problemDescription Se solicita un progrma que genere números aleatorios enteros entre el 1 y el 30,
 * el usuario tiene 5 intentos para adivinar el numero,
 * en cada intento se le dara una pista acorde a el intento anterior.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 16/03/24
 * @lastModification ?
 */

fun generarNumeroAleatorio(): Int {
    return Random.nextInt(1, 31)
}

fun jugar() {
    println("\tADIVINA EL NÚMERO(1-30)\n -> Tedras 5 intentos.")
    var intentos: Int = 5
    val numGanador = generarNumeroAleatorio()
    var numTentativo: Int
    while (intentos > 0) {
        print("¿Cuál crees que es el número?: ")
        numTentativo = readln().toInt()
        when(numTentativo) {
            numGanador -> {println("¡Felicitaciones, adivinaste!")
                exitProcess(1)}
            in 1 until numGanador -> println("El número es MAYOR al que ingresante")
            in (numGanador+1)..30 -> println("El número es MENOR al que ingresante")
        }
        intentos--
    }
    println("\nGame Over, se acabaron los intentos")
}
fun main() {
    jugar()
}