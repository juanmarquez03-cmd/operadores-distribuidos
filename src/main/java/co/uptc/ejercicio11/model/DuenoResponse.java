package co.uptc.ejercicio11.model;

/**
 * DTO que identifica al dueño del servicio.
 */
public class DuenoResponse {

    private String dueno;

    public DuenoResponse() {
    }

    public DuenoResponse(String dueno) {
        this.dueno = dueno;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }
}
