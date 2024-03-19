/**
 * @problemDescription Se solicita saber cuantos alumnos hay en un salon, preguntar la eda de cada uno de estos,
 * saber el maximo y mino de edad y mostrar la edad de todos. Implementar sin usar LISTAS.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 16/03/24
 * @lastModification 19/03/24
 */

fun ingreseAlumnos(cantidad: Int) {
    println("Ingrese la EDAD de cada alumno")
    val edadesAlumnos = IntArray(cantidad)
    for (i in 0 until cantidad) {
        print("Alumno ${i+1}: ")
        edadesAlumnos[i] = readln().toInt()
    }
    println("\nEJEMPLO: $cantidad Alumnos")
    calcularEdadMaximaMinima(edadesAlumnos)
    imprimirTodasLasEdades(edadesAlumnos)
}

fun calcularEdadMaximaMinima(alumnos: IntArray) {
    var edadMaxima = 0
    var edadMinima = Int.MAX_VALUE
    println("=== Edades ===")
    for (edadActual in alumnos) {
        if (edadActual > edadMaxima) {
            edadMaxima = edadActual
        }
        if (edadActual < edadMinima) {
            edadMinima = edadActual
        }
    }
    println("Edad máxima: $edadMaxima")
    println("Edad mínima: $edadMinima")
}

fun imprimirTodasLasEdades(alumnos: IntArray) {
    print("Todos = ")
    for(edadActual in alumnos.dropLast(1)) {
        print("$edadActual, ")
    }
    println(alumnos.last())

}

/*------SIN USAR ARRAYS(LISTAS)------*/

fun realizarEstadisticaSinListas(cantidad: Int) {
    var edadActual: Int
    var edadMaxima = 0
    var edadMinima = Int.MAX_VALUE
    var todasLasEdades = ""

    println("Ingrese la EDAD de cada alumno")
    for (i in 1..cantidad) {
        print("Alumno $i: ")
        edadActual = readln().toInt()
        todasLasEdades += "$edadActual, "

        if (edadActual > edadMaxima) {
            edadMaxima = edadActual
        }
        if (edadActual < edadMinima) {
            edadMinima = edadActual
        }
    }
    println("\nEJEMPLO: $cantidad Alumnos")
    println("=== Edades ===")
    println("Edad máxima: $edadMaxima")
    println("Edad mínima: $edadMinima")

    //imprimimos todas las edades:
    println("Todos = ${todasLasEdades.dropLast(2)}")

}
fun main() {
    print("Ingrese la cantidad de alumnos del salon: ")
    val cantidad: Int = readln().toInt()
    //ingreseAlumnos(cantidad)
    realizarEstadisticaSinListas(cantidad)
}


