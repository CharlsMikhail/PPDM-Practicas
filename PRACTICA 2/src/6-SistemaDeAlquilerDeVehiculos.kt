/**
 * @problemDescription Se solicita diseñar una interfaz de Vehiculo Alquilable el cual sirva a las clases
 * Coche y Moto.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 24/03/24
 * @lastModification 28/03/24
 */

interface VehiculoAlquilabe {
    fun alquilarVehiculo()
    fun devolverVehiculo()
}

class Coche: VehiculoAlquilabe {
    override fun alquilarVehiculo() {
        println("El ${toString()} fue alquilado")
    }
    override fun devolverVehiculo() {
        println("El ${toString()} fue devuelto")
    }
}
class Moto: VehiculoAlquilabe {
    override fun alquilarVehiculo() {
        println("La ${toString()} fue alquilada")
    }
    override fun devolverVehiculo() {
        println("La ${toString()} fue devuelta")
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