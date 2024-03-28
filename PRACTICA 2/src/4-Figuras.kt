import kotlin.math.PI

/**
 * @problemDescription Se solicita implementar una clase abstracta Figura que contenga propiedades generarles
 * (área y perimetro)de las figuras: Cudarado, Circulo y Rectangulo.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 24/03/24
 * @lastModification 28/03/24
 */

abstract class Shape(protected var area: Double = .0, protected var perimetro: Double = .0) {
    abstract fun calcularArea()
    abstract fun calcularPerimetro()
    fun imprimirResultados() {
        println("Su area es: $area")
        println("Su perimetro es: $perimetro")
    }
}

class Cuadrado(private var lado: Double): Shape() {
    override fun calcularArea() {
        area = lado * lado
    }
    override fun calcularPerimetro() {
         perimetro = lado * 4
    }
}

class Circulo(private var radio: Double): Shape() {
    override fun calcularArea() {
        area = PI * (radio*radio)
    }
    override fun calcularPerimetro() {
        perimetro = 2 * PI * radio
    }
}

class Rectangulo(private var base: Double, private var altura: Double): Shape() {
    override fun calcularArea() {
        area = base * altura
    }
    override fun calcularPerimetro() {
        perimetro = 2 * (base + altura)
    }
}

fun main() {
    // Verificamos que el código este bien implementado
    val cuadrado = Cuadrado(3.0)
    println("Cuadrado:")
    cuadrado.calcularArea()
    cuadrado.calcularPerimetro()
    cuadrado.imprimirResultados()

    println("\nCírculo:")
    val circulo = Circulo(2.0)
    circulo.calcularArea()
    circulo.calcularPerimetro()
    circulo.imprimirResultados()

    println("\nRectángulo:")
    val rectangulo = Rectangulo(12.0, 6.0)
    rectangulo.calcularArea()
    rectangulo.calcularPerimetro()
    rectangulo.imprimirResultados()
}