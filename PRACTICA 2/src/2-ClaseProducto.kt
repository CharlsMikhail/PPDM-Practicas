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
                println("Error el precio no puede ser negativo")
        }
        get() = field

    private var descuento: Double = 0.0
        set(value) {
            if (value <= precio)
                field = value
            else
                println("El descuento no puede ser mayor que el precio")
        }
        get() = field

    fun calcularPrecioFinal(): Double = precio - descuento
}

fun main() {
    //Probando el correcto funcionamiento del diseño
    val producto = Producto(30.0, 5.0)
    println(producto.calcularPrecioFinal())
}