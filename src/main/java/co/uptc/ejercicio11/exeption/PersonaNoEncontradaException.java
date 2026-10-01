package co.uptc.ejercicio11.exeption;

/**
 * Se lanza cuando no existe ninguna persona con el id solicitado en el CSV.
 */
public class PersonaNoEncontradaException extends PersonaException {

    public PersonaNoEncontradaException(Long id) {
        super("No se encontró la persona con id " + id);
    }
}
