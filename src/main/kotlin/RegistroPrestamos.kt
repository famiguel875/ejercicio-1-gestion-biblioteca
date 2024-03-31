import java.util.UUID

/**
 * Clase que representa el registro de préstamos de la biblioteca, contiene métodos para prestar y devolver libros.
 * @param inventario El gestor de biblioteca que contiene los libros y su información.
 */
class RegistroPrestamos(private val inventario: GestorBiblioteca) {
    /**
     * Registra el préstamo de un libro.
     * @param id El ID del libro a prestar.
     */
    fun prestarLibro(id: UUID) {
        if (inventario.estaDisponible(id)) {
            inventario.cambiarEstadoLibro(id, EstadoLibro.PRESTADO)
            GestorMensajes.log("Libro prestado con ID: $id")
        } else {
            GestorMensajes.error("El libro con ID $id no está disponible para préstamo.")
        }
    }

    /**
     * Registra la devolución de un libro.
     * @param id El ID del libro a devolver.
     */
    fun devolverLibro(id: UUID)  {
        if (inventario.estaPrestado(id)) {
            inventario.cambiarEstadoLibro(id, EstadoLibro.DISPONIBLE)
            GestorMensajes.log("Libro devuelto con ID: $id")
        } else {
            GestorMensajes.error("El libro con ID $id ya está en el inventario.")
        }
    }
}