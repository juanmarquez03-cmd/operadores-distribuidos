package co.uptc.ejercicio11.exeption;

/**
 * Se lanza cuando el número de página solicitado para el listado de
 * Personas no es válido (por ejemplo, negativo).
 */
public class PaginaInvalidaException extends PersonaException {

    public PaginaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
