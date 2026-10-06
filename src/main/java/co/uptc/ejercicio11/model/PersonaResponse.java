package co.uptc.ejercicio11.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * Respuesta del endpoint de consulta de una Persona por id. Los campos de la
 * persona se serializan "aplanados" (sin objeto anidado), de modo que el JSON
 * conserva la estructura original y solo agrega los campos hostname y dueno.
 */
@JsonPropertyOrder({"persona", "hostname", "dueno"})
public class PersonaResponse {

    @JsonUnwrapped
    private Persona persona;
    private String hostname;
    private String dueno;

    public PersonaResponse() {
    }

    public PersonaResponse(Persona persona, String hostname, String dueno) {
        this.persona = persona;
        this.hostname = hostname;
        this.dueno = dueno;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
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
