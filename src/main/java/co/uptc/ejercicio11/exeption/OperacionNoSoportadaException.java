package co.uptc.ejercicio11.exeption;

/*
 * Se lanza cuando se solicita una operación que la calculadora no reconoce o no soporta.
 */
public class OperacionNoSoportadaException extends CalculadoraException {

    public OperacionNoSoportadaException(String operacion) {
        super("La operación '" + operacion + "' no está soportada por la calculadora");
    }
}
