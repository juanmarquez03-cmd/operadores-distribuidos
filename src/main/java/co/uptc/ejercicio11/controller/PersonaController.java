package co.uptc.ejercicio11.controller;

import co.uptc.ejercicio11.model.PersonaPage;
import co.uptc.ejercicio11.model.PersonaResponse;
import co.uptc.ejercicio11.model.PersonaUpdateRequest;
import co.uptc.ejercicio11.service.PersonaService;
import org.springframework.web.bind.annotation.*;

/**
 * Expone los endpoints REST de Personas. Su única responsabilidad es recibir
 * la petición, delegar en la capa de servicio y traducir el resultado (o
 * excepción) a una respuesta HTTP.
 */
@RestController
@RequestMapping("/api/personas")
public class PersonaController {

    private final PersonaService personaService;

    public PersonaController(PersonaService personaService) {
        this.personaService = personaService;
    }

    @GetMapping
    public PersonaPage listar(@RequestParam(name = "pagina", defaultValue = "0") int pagina,
                              @RequestParam(name = "tamanioPagina", defaultValue = "50") int tamanioPagina) {
        return personaService.listarPaginado(pagina, tamanioPagina);
    }

    @GetMapping("/{id}")
    public PersonaResponse obtenerPorId(@PathVariable Long id) {
        return personaService.obtenerPorId(id);
    }

    @PutMapping("/{id}")
    public PersonaResponse actualizar(@PathVariable Long id, @RequestBody PersonaUpdateRequest datos) {
        return personaService.actualizar(id, datos);
    }
}
