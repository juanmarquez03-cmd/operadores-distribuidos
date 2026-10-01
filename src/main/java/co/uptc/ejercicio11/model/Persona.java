package co.uptc.ejercicio11.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

/**
 * Entidad que representa una persona almacenada en la tabla personas de
 * PostgreSQL.
 */
@Entity
@Table(name = "personas")
public class Persona {

    @Id
    @Column(name = "id")
    private Long id;

    @Column(name = "primer_nombre", length = 60)
    private String primerNombre;

    @Column(name = "segundo_nombre", length = 60)
    private String segundoNombre;

    @Column(name = "primer_apellido", length = 60)
    private String primerApellido;

    @Column(name = "segundo_apellido", length = 60)
    private String segundoApellido;

    public Persona() {
    }

    public Persona(Long id, String primerNombre, String segundoNombre, String primerApellido, String segundoApellido) {
        this.id = id;
        this.primerNombre = primerNombre;
        this.segundoNombre = segundoNombre;
        this.primerApellido = primerApellido;
        this.segundoApellido = segundoApellido;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre;
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido;
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido;
    }
}
