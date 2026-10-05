package co.uptc.ejercicio11.service;

import co.uptc.ejercicio11.model.PersonaPage;
import co.uptc.ejercicio11.model.PersonaResponse;
import co.uptc.ejercicio11.model.PersonaUpdateRequest;

/**
 * Define las operaciones de negocio disponibles sobre Personas.
 */
public interface PersonaService {

    PersonaPage listarPaginado(int pagina, int tamanioPagina);

    PersonaResponse obtenerPorId(Long id);

    PersonaResponse actualizar(Long id, PersonaUpdateRequest datos);
}
