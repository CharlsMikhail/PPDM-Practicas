import java.lang.IllegalArgumentException

/**
 * @problemDescription Se solicita diseñar la clase "Producto" que tenga un precio y un descuento con este ultimo
 * implementar el calulo del precio final.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 23/03/24
 * @lastModification ?
 */

class Producto(precio: Float, descuento: Float) {
    var precio: Float = if (precio >= 0) precio
    else {
        throw IllegalArgumentException("El precio no puede ser nagativo")
    }
        set(precioNuevo) {
            if (precioNuevo >= 0)
                field = precioNuevo
            else
                println("Error el precio no puede ser negativo")
        }
        get() {
            return field
        }
    var descuento: Float = if (descuento <= this.precio) descuento
        else {
            throw IllegalArgumentException("El descuento no puede ser mayor al precio")
        }
        set(descuentoNuevo) {
            if (descuentoNuevo <= precio)
                field = descuentoNuevo
            else
                println("El descuento no puede ser menor que el precio")
        }
        get() {
            return field
        }
    fun calcularPrecioFinal(): Float {
        return precio - descuento
    }
}

fun main() {
    //Probando el correcto funcionamiento del diseño
    val producto = Producto(30F, 5F)
    println(producto.calcularPrecioFinal())

    //producto.descuento = 31F

}