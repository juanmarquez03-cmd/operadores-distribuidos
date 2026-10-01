package co.uptc.ejercicio11.model;

import jakarta.validation.constraints.NotNull;
/**
 * DTO que representa la petición de una operación aritmética.
 */
public class OperacionRequest {

    @NotNull(message = "El valor 'numero1' es obligatorio")
    private Double numero1;

    @NotNull(message = "El valor 'numero2' es obligatorio")
    private Double numero2;

    public OperacionRequest() {
    }

    public OperacionRequest(Double numero1, Double numero2) {
        this.numero1 = numero1;
        this.numero2 = numero2;
    }

    public Double getNumero1() {
        return numero1;
    }

    public void setNumero1(Double numero1) {
        this.numero1 = numero1;
    }

    public Double getNumero2() {
        return numero2;
    }

    public void setNumero2(Double numero2) {
        this.numero2 = numero2;
    }
}
