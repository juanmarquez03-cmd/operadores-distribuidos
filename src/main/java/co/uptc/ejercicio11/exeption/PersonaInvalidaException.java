package co.uptc.ejercicio11.exeption;

/**
 * Se lanza cuando los datos enviados para crear o actualizar una Persona no
 * cumplen las reglas de validación (campos obligatorios, longitud máxima).
 */
public class PersonaInvalidaException extends PersonaException {

    public PersonaInvalidaException(String mensaje) {
        super(mensaje);
    }
}
