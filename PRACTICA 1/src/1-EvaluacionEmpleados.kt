/**
 * @problemDescription Se solicita que a base del salario(base) y puntuacion del empleado se devuelva el nivel de
 * rendimiento(se halla a base de la puntuación) junto a el salario(neto) que tiene como formula: salario(base) *
 * (puntuación / 10).
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 16/03/24
 * @lastModification ?
 */
fun calcularNivelDeRedimiento(puntuacion: Int): String {
    return when (puntuacion) {
        in 0..3 -> "Inaceptable"
        in 4..6 -> "Aceptable"
        in 7..10 -> "Meritorio"
        else -> "Error, puntuación fuera del intervalo"
    }
}
fun calcularSalarioNeto(salario: Float, puntuacion: Int): Float {
    return salario * (puntuacion.toFloat() / 10)
}

fun main() {
    print("Ingrese su salario mensual: ")
    val salario: Float = readln().toFloat()
    print("Ingrese su puntuacion: ")
    val puntuacion: Int = readln().toInt()
    println("\nRESULTADOS:\n Nivel de rendimiento: ${calcularNivelDeRedimiento(puntuacion)}\n Salario neto: ${calcularSalarioNeto(salario, puntuacion)} ")
}