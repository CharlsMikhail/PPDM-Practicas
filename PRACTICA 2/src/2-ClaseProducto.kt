import java.lang.IllegalArgumentException

/**
 * @problemDescription Se solicita diseñar la clase "Producto" que tenga un precio y un descuento con este ultimo
 * implementar el calulo del precio final.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 23/03/24
 * @lastModification 28/03/24
 */

class Producto(precio: Double, descuento: Double) {
    private var precio: Double = 0.0
        set(value) {
            if (value >= 0)
                field = value
            else
                throw IllegalArgumentException("Error, el precio no puede ser negativo")
        }
        get() = field

    // El descuento es manejado en porcentaje del 0 al 100
    private var descuento: Double = 0.0
        set(value) {
            if (value in 0.0..100.0)
                field = value
            else
                throw IllegalArgumentException("Error, el descuento debe estar entre 0 y 100")
        }
        get() = field

    //Usamos init para que las resticciones de los setters se cumplan al inicio.
    init {
        this.precio = precio
        this.descuento = descuento
    }

    fun calcularPrecioFinal(): Double = precio - (precio * descuento/100)
    // Como los atributos estan encapsulados se puede agregar funciones para tener acceso,
    // pero estas tienen que tener diferente firma a set y get, por ejemplo: updatePrecio().
}

fun main() {
    //Probando el correcto funcionamiento del diseño propuesto.
    val producto = Producto(140.0, 50.0)
    println("Precio final: ${producto.calcularPrecioFinal()}")
}