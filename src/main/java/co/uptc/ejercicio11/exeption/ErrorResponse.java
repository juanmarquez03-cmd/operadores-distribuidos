package co.uptc.ejercicio11.exeption;

import java.time.LocalDateTime;

/**
 * Estructura estándar utilizada para devolver errores al cliente de forma consistente.
 */
public class ErrorResponse {

    private LocalDateTime fecha;
    private int status;
    private String error;
    private String mensaje;
    private String path;

    public ErrorResponse() {
        this.fecha = LocalDateTime.now();
    }

    public ErrorResponse(int status, String error, String mensaje, String path) {
        this();
        this.status = status;
        this.error = error;
        this.mensaje = mensaje;
        this.path = path;
    }

    public LocalDateTime getFecha() {
        return fecha;
    }

    public void setFecha(LocalDateTime fecha) {
        this.fecha = fecha;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
