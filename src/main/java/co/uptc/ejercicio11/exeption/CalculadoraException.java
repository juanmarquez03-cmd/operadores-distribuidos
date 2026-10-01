package co.uptc.ejercicio11.exeption;

/**
 * Excepción base para todos los errores de negocio de la calculadora.
 * Todas las excepciones específicas del dominio deben extender de esta clase.
 */
public class CalculadoraException extends RuntimeException {

    public CalculadoraException(String mensaje) {
        super(mensaje);
    }

    public CalculadoraException(String mensaje, Throwable causa) {
        super(mensaje, causa);
    }
}
