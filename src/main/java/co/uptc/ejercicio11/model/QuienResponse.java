package co.uptc.ejercicio11.model;

/**
 * DTO que identifica qué instancia del contenedor atendió la petición.
 */
public class QuienResponse {

    private String hostname;
    private String dueno;

    public QuienResponse() {
    }

    public QuienResponse(String hostname, String dueno) {
        this.hostname = hostname;
        this.dueno = dueno;
    }

    public String getHostname() {
        return hostname;
    }

    public void setHostname(String hostname) {
        this.hostname = hostname;
    }

    public String getDueno() {
        return dueno;
    }

    public void setDueno(String dueno) {
        this.dueno = dueno;
    }
}
