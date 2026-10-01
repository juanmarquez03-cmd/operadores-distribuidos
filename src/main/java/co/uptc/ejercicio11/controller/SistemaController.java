package co.uptc.ejercicio11.controller;

import co.uptc.ejercicio11.model.QuienResponse;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * Expone endpoints informativos sobre la instancia del sistema, útiles para
 * demostrar el balanceo de carga entre varias réplicas del contenedor.
 */
@RestController
@RequestMapping("/api")
public class SistemaController {

    @GetMapping("/quien")
    public QuienResponse quien() {
        return new QuienResponse(resolverHostname());
    }

    private String resolverHostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return System.getenv().getOrDefault("HOSTNAME", "desconocido");
        }
    }
}
