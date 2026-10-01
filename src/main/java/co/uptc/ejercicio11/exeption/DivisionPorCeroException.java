package co.uptc.ejercicio11.exeption;


/**
 * Se lanza cuando se intenta dividir un número entre cero.
 */
public class DivisionPorCeroException extends CalculadoraException {

    public DivisionPorCeroException() {

        super("No es posible dividir entre cero");
    }
}
