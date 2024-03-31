import java.util.UUID

/**
 * Clase que representa el gestor de la biblioteca, contiene métodos para agregar, remover y gestionar libros.
 */
class GestorBiblioteca {

    private val libros = mutableListOf<Libro>()

    /**
     * Agrega un libro al catálogo de la biblioteca.
     * @param libro El libro a agregar.
     */

    fun agregarLibro(libro: Libro) {
        libros.add(libro)
        GestorMensajes.log("Libro agregado: ${libro.titulo}")
    }

    /**
     * Remueve un libro del catálogo de la biblioteca.
     * @param libro El libro a remover.
     */
    fun removerLibro(libro: Libro) {
        libros.remove(libro)
        GestorMensajes.log("Libro removido: ${libro.titulo}")
    }

    /**
     * Cambia el estado de un libro dado su ID.
     * @param id El ID del libro.
     * @param nuevoEstado El nuevo estado del libro.
     */
    fun cambiarEstadoLibro(id: UUID, nuevoEstado: EstadoLibro) {
        libros.find { it.id == id }?.let {
            it.estado = nuevoEstado
            GestorMensajes.log("Estado cambiado a $nuevoEstado para el libro: ${it.titulo}")
        }
    }

    /**
     * Verifica si un libro está disponible dado su ID.
     * @param id El ID del libro.
     * @return true si el libro está disponible, false en caso contrario.
     */
    fun estaDisponible(id: UUID): Boolean {
        return libros.any { it.id == id && it.estado == EstadoLibro.DISPONIBLE }
    }

    /**
     * Verifica si un libro está prestado dado su ID.
     * @param id El ID del libro.
     * @return true si el libro está prestado, false en caso contrario.
     */
    fun estaPrestado(id: UUID): Boolean {
        return libros.any { it.id == id && it.estado == EstadoLibro.PRESTADO }
    }

    /**
     * Retorna una lista de todos los libros en el catálogo.
     * @return Lista de libros.
     */
    fun listarTodosLosLibros(): List<Libro> = libros

    /**
     * Retorna una lista de libros disponibles para préstamo.
     * @return Lista de libros disponibles.
     */
    fun listarLibrosDisponibles(): List<Libro> = libros.filter { it.estado == EstadoLibro.DISPONIBLE }

    /**
     * Retorna una lista de libros prestados.
     * @return Lista de libros prestados.
     */
    fun listarLibrosPrestados(): List<Libro> = libros.filter { it.estado == EstadoLibro.PRESTADO }

}