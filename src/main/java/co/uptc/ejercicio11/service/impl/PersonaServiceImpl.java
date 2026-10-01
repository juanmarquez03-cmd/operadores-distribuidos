package co.uptc.ejercicio11.service.impl;

import co.uptc.ejercicio11.exeption.PaginaInvalidaException;
import co.uptc.ejercicio11.exeption.PersonaNoEncontradaException;
import co.uptc.ejercicio11.model.Persona;
import co.uptc.ejercicio11.model.PersonaPage;
import co.uptc.ejercicio11.model.PersonaResponse;
import co.uptc.ejercicio11.repository.PersonaRepository;
import co.uptc.ejercicio11.service.HostnameService;
import co.uptc.ejercicio11.service.PersonaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Implementación de la lógica de negocio de Personas. Delega la paginación
 * en Spring Data (Pageable) y agrega a la respuesta el hostname de la
 * instancia que atendió la petición.
 */
@Service
@Transactional(readOnly = true)
public class PersonaServiceImpl implements PersonaService {

    private final PersonaRepository personaRepository;
    private final HostnameService hostnameService;

    public PersonaServiceImpl(PersonaRepository personaRepository, HostnameService hostnameService) {
        this.personaRepository = personaRepository;
        this.hostnameService = hostnameService;
    }

    @Override
    public PersonaPage listarPaginado(int pagina, int tamanioPagina) {
        if (pagina < 0) {
            throw new PaginaInvalidaException("El número de página no puede ser negativo: " + pagina);
        }
        if (tamanioPagina <= 0) {
            throw new PaginaInvalidaException("El tamaño de página debe ser mayor que cero: " + tamanioPagina);
        }

        // Se ordena por id para que la paginación sea estable entre peticiones.
        Pageable pageable = PageRequest.of(pagina, tamanioPagina, Sort.by("id"));
        Page<Persona> resultado = personaRepository.findAll(pageable);

        PersonaPage page = new PersonaPage(
                resultado.getContent(),
                resultado.getNumber(),
                resultado.getSize(),
                resultado.getTotalElements(),
                resultado.getTotalPages()
        );
        page.setHostname(hostnameService.obtenerHostname());
        return page;
    }

    @Override
    public PersonaResponse obtenerPorId(Long id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new PersonaNoEncontradaException(id));
        return new PersonaResponse(persona, hostnameService.obtenerHostname());
    }
}
