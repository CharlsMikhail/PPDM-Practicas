/**
 * @problemDescription Se solicita saber cunatos alumnos hay en un salon, preguntar la eda de cada uno de estos,
 * saber el maximo y mino de edad y mostrar la edad de todos.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 16/03/24
 * @lastModification ?
 */

fun ingreseAlumnos(cantidad: Int) {
    println("Ingrese la EDAD de cada alumno")
    val edadesAlumnos = IntArray(cantidad)
    for (i in 0 until cantidad) {
        print("Alumno: ${i+1} ")
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
    for(edadActual in alumnos) {
        print("$edadActual,")
    }
}

fun main() {
    print("Ingrese la cantidad de alumnos del salon: ")
    val cantidad: Int = readln().toInt()
    ingreseAlumnos(cantidad)
}

