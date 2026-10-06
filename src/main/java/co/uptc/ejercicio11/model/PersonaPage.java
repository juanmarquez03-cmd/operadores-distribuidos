package co.uptc.ejercicio11.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;

/**
 * Página de resultados devuelta por el endpoint de listado de Personas.
 * Evita transportar la tabla completa en una sola respuesta.
 */
@JsonPropertyOrder({"contenido", "pagina", "tamanioPagina", "totalElementos", "totalPaginas", "hostname", "dueno"})
public class PersonaPage {

    private List<Persona> contenido;
    private int pagina;
    private int tamanioPagina;
    private long totalElementos;
    private int totalPaginas;
    private String hostname;
    private String dueno;

    public PersonaPage() {
    }

    public PersonaPage(List<Persona> contenido, int pagina, int tamanioPagina,
                        long totalElementos, int totalPaginas) {
        this.contenido = contenido;
        this.pagina = pagina;
        this.tamanioPagina = tamanioPagina;
        this.totalElementos = totalElementos;
        this.totalPaginas = totalPaginas;
    }

    public List<Persona> getContenido() {
        return contenido;
    }

    public void setContenido(List<Persona> contenido) {
        this.contenido = contenido;
    }

    public int getPagina() {
        return pagina;
    }

    public void setPagina(int pagina) {
        this.pagina = pagina;
    }

    public int getTamanioPagina() {
        return tamanioPagina;
    }

    public void setTamanioPagina(int tamanioPagina) {
        this.tamanioPagina = tamanioPagina;
    }

    public long getTotalElementos() {
        return totalElementos;
    }

    public void setTotalElementos(long totalElementos) {
        this.totalElementos = totalElementos;
    }

    public int getTotalPaginas() {
        return totalPaginas;
    }

    public void setTotalPaginas(int totalPaginas) {
        this.totalPaginas = totalPaginas;
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
