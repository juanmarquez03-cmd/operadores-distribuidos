package co.uptc.ejercicio11.service;

/**
 * Define las operaciones aritméticas básicas que debe ofrecer la calculadora.
 * Separar la interfaz de la implementación permite desacoplar el controlador
 * de los detalles concretos del cálculo (útil para pruebas y para sustituir
 * la lógica sin afectar a las demás capas).
 */
public interface CalculadoraService {

    double sumar(double numero1, double numero2);

    double restar(double numero1, double numero2);

    double multiplicar(double numero1, double numero2);

    double dividir(double numero1, double numero2);
}
