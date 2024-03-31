import java.util.UUID

fun main() {
    val libro1 = Libro(UUID.randomUUID(), "El señor de los anillos", "J.R.R. Tolkien", 1954, "Fantasía")
    val libro2 = Libro(UUID.randomUUID(), "Cien años de soledad", "Gabriel García Márquez", 1967, "Realismo mágico")
    val libro3 = Libro(UUID.randomUUID(), "1984", "George Orwell", 1949, "Distopía")

    val gestorInventario = GestorBiblioteca()
    gestorInventario.agregarLibro(libro1)
    gestorInventario.agregarLibro(libro2)
    gestorInventario.agregarLibro(libro3)

    val sistemaPrestamos = RegistroPrestamos(gestorInventario)

    GestorMensajes.log("Prestar libros:")
    sistemaPrestamos.prestarLibro(libro1.id) // Libro 1 prestado
    sistemaPrestamos.prestarLibro(libro2.id) // Libro 2 prestado

    GestorMensajes.log("\nIntentar prestar un libro ya prestado:")
    sistemaPrestamos.prestarLibro(libro1.id) // Intento fallido, libro 1 ya está prestado

    GestorMensajes.log("\nDevolver un libro")
    sistemaPrestamos.devolverLibro(libro2.id) // Libro 2 devuelto

    GestorMensajes.log("\nIntentar devolver un libro ya devuelto:")
    sistemaPrestamos.devolverLibro(libro2.id) // Intento fallido, libro 2 ya está devuelto

    GestorMensajes.log("\nEliminar un libro:")
    gestorInventario.removerLibro(libro2) // Libro 2 eliminado del inventario

    val generadorInformes = Catalogo(gestorInventario)
    generadorInformes.catalogoLibrosCompleto() // Genera un informe detallado de todos los libros
    generadorInformes.catalogoLibrosDisponibles() // Genera un informe de los libros disponibles
    generadorInformes.catalogoLibrosPrestados() // Genera un informe de los libros prestados
}