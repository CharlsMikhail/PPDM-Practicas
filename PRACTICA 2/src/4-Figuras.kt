import kotlin.math.PI

/**
 * @problemDescription Se solicita implementar una clase abstracta Figura que contenga propiedades generarles
 * (área y perimetro)de las figuras: Cudarado, Circulo y Rectangulo.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 24/03/24
 * @lastModification ?
 */

abstract class Shape(var area: Double = .0, var perimetro: Double = .0) {
    abstract fun calcularArea()
    abstract fun calcularPerimetro()
    fun imprimirResultados() {
        println("El area es: $area")
        println("El perimetro es: $perimetro")
    }
}

class Cuadrado(var lado: Double): Shape() {
    override fun calcularArea() {
        area = lado * lado
    }
    override fun calcularPerimetro() {
         perimetro = lado * 4
    }
}

class Circulo(var radio: Double): Shape() {
    override fun calcularArea() {
        area = PI * (radio*radio)
    }
    override fun calcularPerimetro() {
        perimetro = 2 * PI * radio
    }
}

class Rectangulo(var base: Double, var altura: Double): Shape() {
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