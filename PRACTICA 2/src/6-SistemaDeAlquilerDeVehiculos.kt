/**
 * @problemDescription Se solicita diseñar una interfaz de Vehiculo Alqulable el cual sirva a las clases
 * Coche y Moto.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 24/03/24
 * @lastModification ?
 */

interface VehiculoAlquilabe {
    fun alquilarVehiculo()
    fun devolverVehiculo()
}

class Coche(): VehiculoAlquilabe {
    override fun alquilarVehiculo() {
        println("El ${this.toString()} fue alquilado")
    }
    override fun devolverVehiculo() {
        println("El ${this.toString()} fue devuelto")
    }
}
class Moto(): VehiculoAlquilabe {
    override fun alquilarVehiculo() {
        println("La ${this.toString()} fue alquilada")
    }
    override fun devolverVehiculo() {
        println("La ${this.toString()} fue devuelta")
    }
}

fun main() {
    // Realizamos verificaiones creando instancias
    val coche = Coche()
    coche.alquilarVehiculo()
    coche.devolverVehiculo()

    val moto = Moto()
    moto.alquilarVehiculo()
    moto.devolverVehiculo()
}