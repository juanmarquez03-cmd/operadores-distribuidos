package co.uptc.ejercicio11.service.impl;

import co.uptc.ejercicio11.exeption.DivisionPorCeroException;
import co.uptc.ejercicio11.service.CalculadoraService;
import org.springframework.stereotype.Service;

/**
 * Implementación concreta de la lógica de negocio de la calculadora.
 * Esta capa no conoce nada de HTTP: solo recibe números y devuelve resultados
 * o lanza excepciones de dominio cuando la operación no es válida.
 */
@Service
public class CalculadoraServiceImpl implements CalculadoraService {

    @Override
    public double sumar(double numero1, double numero2) {
        return numero1 + numero2;
    }

    @Override
    public double restar(double numero1, double numero2) {
        return numero1 - numero2;
    }

    @Override
    public double multiplicar(double numero1, double numero2) {
        return numero1 * numero2;
    }

    @Override
    public double dividir(double numero1, double numero2) {
        if (numero2 == 0) {
            throw new DivisionPorCeroException();
        }
        return numero1 / numero2;
    }
}
