/**
 * Clase que maneja los mensajes de log y errores del sistema.
 */
class GestorMensajes {
    companion object {
        /**
         * Imprime un mensaje de log.
         * @param texto El texto del mensaje.
         */
        fun log(texto: String) {
            println("[LOG] $texto")
        }

        /**
         * Imprime un mensaje de error.
         * @param texto El texto del mensaje.
         */
        fun error(texto: String) {
            println("[ERROR] $texto")
        }
    }
}