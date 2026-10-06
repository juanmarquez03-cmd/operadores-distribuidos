package co.uptc.ejercicio11.service.impl;

import co.uptc.ejercicio11.service.DuenoService;
import org.springframework.stereotype.Service;

@Service
public class DuenoServiceImpl implements DuenoService {

    private static final String DUENO = "101010";

    @Override
    public String obtenerDueno() {
        return DUENO;
    }
}
