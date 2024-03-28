/**
 * @problemDescription Se solicita implementar un sistema de gestión de empleados aplicando herencia y polimorfismo.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 24/03/24
 * @lastModification 28/03/24
 */

// Agregamos horasTrabajadas y tarifaHora como atributos de esta clase abstracta ya que en los hijos se repite.
abstract class Empleado(
    protected val nombre: String,
    protected val apellido: String,
    protected var edad: Int,
    protected var salario: Double,
    protected var horasTrabajadas: Int,
    protected var tarifaHora: Double
) {
    abstract fun calcularPago(): Double
    fun fetchNombre(): String = nombre
}

class EmpleadoTiempoCompleto(
    nombre: String,
    apellido: String,
    edad: Int,
    salario: Double,
    horasTrabajadas: Int,
    tarifaHora: Double
) : Empleado(nombre, apellido, edad, salario, horasTrabajadas, tarifaHora) {
    override fun calcularPago(): Double = horasTrabajadas * tarifaHora
}

class EmpleadoMedioTiempo(
    nombre: String,
    apellido: String,
    edad: Int,
    salario: Double,
    horasTrabajadas: Int,
    tarifaHora: Double,
    private var diasTrabajados: Int
) : Empleado(nombre, apellido, edad, salario, horasTrabajadas, tarifaHora) {
    // De los días trabajados se toman 4 horas, ya que es un empleado de medio tiempo.
    override fun calcularPago(): Double = (horasTrabajadas + (diasTrabajados * 4)) * tarifaHora
}

fun main() {
    // Realizamos las pruebas para contrastar que la implementación sea la correcta.
    val empleado1 = EmpleadoTiempoCompleto(
        "Carlos",
        "Mamani",
        20,
        2500.0,
        58,
        25.0
    )
    println("El pago estimado del empleado ${empleado1.fetchNombre()} es: S./${empleado1.calcularPago()}")

    val empleado2 = EmpleadoMedioTiempo(
        "Abel",
        "Aragon",
        22,
        1050.0,
        52,
        20.0,
        5
    )
    println("El pago estimado del empleado ${empleado2.fetchNombre()} es: S./${empleado2.calcularPago()}")
}