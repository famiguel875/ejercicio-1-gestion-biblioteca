import java.util.UUID

/**
 * Clase que representa un libro de la biblioteca.
 * @property id El ID único del libro.
 * @property titulo El título del libro.
 * @property autor El autor del libro.
 * @property anioPublicacion El año de publicación del libro.
 * @property tematica La temática del libro.
 * @property estado El estado del libro (disponible o prestado).
 */
data class Libro(
    val id: UUID,
    val titulo: String,
    val autor: String,
    val anioPublicacion: Int,
    val tematica: String,
    var estado: EstadoLibro = EstadoLibro.DISPONIBLE
) {
    init {
        require(titulo.isNotEmpty()) { "El libro debe tener titulo" }
        require(autor.isNotEmpty()) { "El libro debe tener autor" }
        require(anioPublicacion > 0) { "El año de publicación debe ser mayor a 0" }
        require(tematica.isNotEmpty()) { "El libro debe tener tematica" }
    }
}