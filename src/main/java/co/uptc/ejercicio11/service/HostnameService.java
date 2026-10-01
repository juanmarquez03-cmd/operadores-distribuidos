package co.uptc.ejercicio11.service;

/**
 * Proporciona información sobre la instancia (host/contenedor) en la que
 * se ejecuta la aplicación.
 */
public interface HostnameService {

    /**
     * @return el nombre del host donde corre la aplicación, o "desconocido"
     *         si no fue posible resolverlo.
     */
    String obtenerHostname();
}
