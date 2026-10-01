package co.uptc.ejercicio11.model;

import com.fasterxml.jackson.annotation.JsonUnwrapped;

/**
 * Respuesta del endpoint de consulta de una Persona por id. Los campos de la
 * persona se serializan "aplanados" (sin objeto anidado), de modo que el JSON
 * conserva la estructura original y solo agrega el campo hostname.
 */
public class PersonaResponse {

    @JsonUnwrapped
    private Persona persona;
    private String hostname;

    public PersonaResponse() {
    }

    public PersonaResponse(Persona persona, String hostname) {
        this.persona = persona;
        this.hostname = hostname;
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
}
