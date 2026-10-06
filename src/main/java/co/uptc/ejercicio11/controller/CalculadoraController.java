package co.uptc.ejercicio11.controller;

import co.uptc.ejercicio11.model.*;
import co.uptc.ejercicio11.service.*;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/calculadora")
public class CalculadoraController {

    private final CalculadoraService calculadoraService;

    public CalculadoraController(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @PostMapping("/sumar")
    public OperacionResponse sumar(@Valid @RequestBody OperacionRequest request) {
        double resultado = calculadoraService.sumar(request.getNumero1(), request.getNumero2());
        return construirRespuesta(request, TipoOperacion.SUMA, resultado);
    }

    @PostMapping("/restar")
    public OperacionResponse restar(@Valid @RequestBody OperacionRequest request) {
        double resultado = calculadoraService.restar(request.getNumero1(), request.getNumero2());
        return construirRespuesta(request, TipoOperacion.RESTA, resultado);
    }

    @PostMapping("/multiplicar")
    public OperacionResponse multiplicar(@Valid @RequestBody OperacionRequest request) {
        double resultado = calculadoraService.multiplicar(request.getNumero1(), request.getNumero2());
        return construirRespuesta(request, TipoOperacion.MULTIPLICACION, resultado);
    }

    @PostMapping("/dividir")
    public OperacionResponse dividir(@Valid @RequestBody OperacionRequest request) {
        double resultado = calculadoraService.dividir(request.getNumero1(), request.getNumero2());
        return construirRespuesta(request, TipoOperacion.DIVISION, resultado);
    }

    private OperacionResponse construirRespuesta(OperacionRequest request, TipoOperacion tipo, double resultado) {
        return new OperacionResponse(request.getNumero1(), request.getNumero2(), tipo, resultado);
    }
}
