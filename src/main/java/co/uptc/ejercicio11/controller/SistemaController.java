package co.uptc.ejercicio11.controller;

import co.uptc.ejercicio11.model.DuenoResponse;
import co.uptc.ejercicio11.model.QuienResponse;
import co.uptc.ejercicio11.service.DuenoService;
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

    private final DuenoService duenoService;

    public SistemaController(DuenoService duenoService) {
        this.duenoService = duenoService;
    }

    @GetMapping("/quien")
    public QuienResponse quien() {
        return new QuienResponse(resolverHostname(), duenoService.obtenerDueno());
    }

    @GetMapping("/dueno")
    public DuenoResponse dueno() {
        return new DuenoResponse(duenoService.obtenerDueno());
    }

    private String resolverHostname() {
        try {
            return InetAddress.getLocalHost().getHostName();
        } catch (UnknownHostException e) {
            return System.getenv().getOrDefault("HOSTNAME", "desconocido");
        }
    }
}
