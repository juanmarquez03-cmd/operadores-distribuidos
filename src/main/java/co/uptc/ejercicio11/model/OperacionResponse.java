package co.uptc.ejercicio11.model;


/**
 * DTO que representa el resultado de una operación aritmética.
 */
public class OperacionResponse {

    private Double numero1;
    private Double numero2;
    private TipoOperacion operacion;
    private Double resultado;

    public OperacionResponse() {
    }

    public OperacionResponse(Double numero1, Double numero2, TipoOperacion operacion, Double resultado) {
        this.numero1 = numero1;
        this.numero2 = numero2;
        this.operacion = operacion;
        this.resultado = resultado;
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

    public TipoOperacion getOperacion() {
        return operacion;
    }

    public void setOperacion(TipoOperacion operacion) {
        this.operacion = operacion;
    }

    public Double getResultado() {
        return resultado;
    }

    public void setResultado(Double resultado) {
        this.resultado = resultado;
    }
}
