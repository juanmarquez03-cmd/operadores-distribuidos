package co.uptc.ejercicio11.exeption;

/**
 * Excepción base para todos los errores de negocio relacionados con Personas.
 * Todas las excepciones específicas del dominio deben extender de esta clase.
 */
public class PersonaException extends RuntimeException {

    public PersonaException(String mensaje) {
        super(mensaje);
    }

    public PersonaException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
