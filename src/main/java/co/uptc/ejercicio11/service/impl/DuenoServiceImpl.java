package co.uptc.ejercicio11.service.impl;

import co.uptc.ejercicio11.service.DuenoService;
import org.springframework.stereotype.Service;

/**
 * Devuelve el dueño del servicio. El valor está quemado en el código.
 */
@Service
public class DuenoServiceImpl implements DuenoService {

    private static final String DUENO = "David Marquez";

    @Override
    public String obtenerDueno() {
        return DUENO;
    }
}
