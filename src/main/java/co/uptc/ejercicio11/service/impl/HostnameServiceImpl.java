package co.uptc.ejercicio11.service.impl;

import co.uptc.ejercicio11.service.HostnameService;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Resuelve el nombre del host local. Dentro de un contenedor Docker este
 * valor corresponde al ID (corto) del contenedor, lo que permite identificar
 * qué réplica atendió cada petición detrás del balanceador.
 */
@Service
public class HostnameServiceImpl implements HostnameService {

    private static final String HOSTNAME_DESCONOCIDO = "desconocido";

    @Override
    public String obtenerHostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return HOSTNAME_DESCONOCIDO;
        }
    }
}
