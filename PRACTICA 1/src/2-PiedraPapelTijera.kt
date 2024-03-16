import kotlin.random.Random

/**
 * @problemDescription Se solicita el juego de piedra, papel o tijera haciendo uso del azar de la maquina para poder jugar
 * con ella y definir si gano, perdio o empato.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 16/03/24
 * @lastModification ?
 */

fun jugar(opc: Int) {
    val numAleatorio = Random.nextInt(1, 4)
    println("OPC MAQUINA: $numAleatorio")
    /*Si maquina es piedra = yo gano con papel, pierdo con tijera*/
    /**
     * 1 es piedra
     * 2 es papel
     * 3 es tijera
     */
    when(numAleatorio) {
        opc -> println("¡EMPATE!")
        1 -> {if (opc == 2) println("¡GANASTE!") else println("¡PERDISTE!")}
        2 -> {if (opc == 3) println("¡GANASTE!") else println("¡PERDISTE!")}
        3 -> {if (opc == 1) println("¡GANASTE!") else println("¡PERDISTE!")}
    }
}
fun main() {
    print("Elija una opcion:\n 1) PIEDRA\n 2) PAPEL\n 3) TIJERA\n Opcion: ")
    val opc: Int = readln().toInt()
    if (opc in 1..3) {
        jugar(opc)
    } else {
        println("Error, no puede jugar con la opción ingresada")
    }

}