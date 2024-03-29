/**
 * @problemDescription Se solicita diseñar un sistema de gestión de biblioteca que involucre usuarios y material como
 * revistas y libros.
 * @author Carlos Mijail Mamani Anccasi
 * @creationDate 24/03/24
 * @lastModification 28/03/24
 */

abstract class Material(
    private var titulo: String,
    private var autor: String,
    private var anioPublicacion: Int
) {
    abstract fun mostrarDetalles()

    // Función para mostrar detalles comunes a todas las subclases, de tal manera no se repite código
    protected fun mostrarDetallesComunes() {
        println("Título: $titulo")
        println("Autor: $autor")
        println("Año de publicación: $anioPublicacion")
    }

    // Se accede al atributo "titulo" encapsulado
    fun getTitulo(): String {
        return titulo
    }
}

class Libro(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    private var genero: String,
    private var numPaginas: Int
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        mostrarDetallesComunes() // Llamada a la función común de la superclase
        println("Género: $genero")
        println("Número de páginas: $numPaginas")
    }
}

class Revista(
    titulo: String,
    autor: String,
    anioPublicacion: Int,
    private var issn: String,
    private var volumen: Int,
    private var numEditorial: Int
) : Material(titulo, autor, anioPublicacion) {
    override fun mostrarDetalles() {
        mostrarDetallesComunes() // Llamada a la función común de la superclase
        println("ISSN: $issn")
        println("Volumen: $volumen")
        println("Número de editorial: $numEditorial")
    }
}

class Usuario(private var nombre: String, private var apellido: String, private var edad: Int) {
    fun reservarMaterial(material: Material) {
        println("$nombre $apellido ha reservado el material: ${material.getTitulo()}")
    }

    fun devolverMaterial(material: Material) {
        println("$nombre $apellido ha devuelto el material: ${material.getTitulo()}")
    }
}

class Biblioteca {

    // Se usan listas mutables para controlar el flujo de interacción entre los materiales y los usuarios.
    private val materialesDisponibles = mutableListOf<Material>()
    private val usuariosRegistrados = mutableListOf<Usuario>()

    fun agregarMaterial(material: Material) {
        materialesDisponibles.add(material)
    }

    fun registrarUsuario(usuario: Usuario) {
        usuariosRegistrados.add(usuario)
    }

    fun prestarMaterial(material: Material, usuario: Usuario) {
        if (materialesDisponibles.contains(material)) {
            usuario.reservarMaterial(material)
            materialesDisponibles.remove(material)
        } else {
            println("El material no está disponible para préstamo.")
        }
    }

    fun devolverMaterial(material: Material, usuario: Usuario) {
        usuario.devolverMaterial(material)
        materialesDisponibles.add(material)
    }
}

fun main() {
    // Crear instancias de materiales
    val libro = Libro(
        "Cien años de soledad",
        "Gabriel García Márquez",
        1967,
        "Realismo mágico",
        368
    )
    val revista = Revista(
        "Time",
        "Time Inc.",
        1923,
        "0040-781X",
        202,
        3
    )

    // Crear instancia de usuario
    val usuario = Usuario("Pedro", "Lopez", 21)

    // Crear instancia de biblioteca
    val biblioteca = Biblioteca()

    // Agregar materiales a la biblioteca
    biblioteca.agregarMaterial(libro)
    biblioteca.agregarMaterial(revista)

    // Registrar usuario en la biblioteca
    biblioteca.registrarUsuario(usuario)

    // Realizar operaciones de préstamo y devolución
    biblioteca.prestarMaterial(libro, usuario)
    biblioteca.devolverMaterial(libro, usuario)

    // Mostrar detalles de los materiales
    println("\nDetalles del libro:")
    libro.mostrarDetalles()

    println("\nDetalles de la revista:")
    revista.mostrarDetalles()
}
