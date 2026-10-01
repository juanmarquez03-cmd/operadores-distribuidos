package co.uptc.ejercicio11.model;

/**
 * DTO que identifica qué instancia del contenedor atendió la petición.
 */
public class QuienResponse {

    private String hostname;

    public QuienResponse() {
    }

    public QuienResponse(String hostname) {
        this.hostname = hostname;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }
}
