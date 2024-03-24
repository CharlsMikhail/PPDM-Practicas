/**
 * @problemDescription Se solicita implementar un sistema de gestión de empleados aplicando herencia y polimorfismo.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 24/03/24
 * @lastModification ?
 */

abstract class Empleado(var nombre: String, var apellido: String, var edad: Int, var salario: Float) {
    abstract fun calcularPago(): Float
}
class EmpleadoTiempoCompleto(nombre: String, apellido: String, edad: Int, salario: Float, var horasTrabajadas: Int, var tarifaHora: Float): Empleado(nombre, apellido, edad, salario) {
    override fun calcularPago(): Float {
        return horasTrabajadas * tarifaHora
    }
}
class EmpleadoMedioTiempo(nombre: String, apellido: String, edad: Int, salario: Float, var horasTrabajadas: Int, var tarifaHora: Float, var diasTrabajados: Int): Empleado(nombre, apellido, edad, salario) {
    // De los días trabajados se toman 4 horas, ya que es un empleado de medio tiempo.
    override fun calcularPago(): Float {
        return((horasTrabajadas + (diasTrabajados * 4)) * tarifaHora)
    }
}

fun main() {
    // Realizamos las pruebas para contrastar que la implementación sea el correcto.
    val empleado1 = EmpleadoTiempoCompleto("Carlos", "Mamani", 20, 10295F, 58, 25F)
    println("El pago del empleado ${empleado1.nombre} es: S./${empleado1.calcularPago()}")

    val empleado2 = EmpleadoMedioTiempo("Abel", "Aragon", 22, 10225F, 52, 20F, 5)
    println("El pago del empleado ${empleado2.nombre} es: S./${empleado2.calcularPago()}")
}