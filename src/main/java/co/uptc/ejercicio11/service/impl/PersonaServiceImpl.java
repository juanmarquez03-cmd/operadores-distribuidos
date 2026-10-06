package co.uptc.ejercicio11.service.impl;

import co.uptc.ejercicio11.exeption.PaginaInvalidaException;
import co.uptc.ejercicio11.exeption.PersonaInvalidaException;
import co.uptc.ejercicio11.exeption.PersonaNoEncontradaException;
import co.uptc.ejercicio11.model.Persona;
import co.uptc.ejercicio11.model.PersonaPage;
import co.uptc.ejercicio11.model.PersonaResponse;
import co.uptc.ejercicio11.model.PersonaUpdateRequest;
import co.uptc.ejercicio11.repository.PersonaRepository;
import co.uptc.ejercicio11.service.DuenoService;
import co.uptc.ejercicio11.service.HostnameService;
import co.uptc.ejercicio11.service.PersonaService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * Implementación de la lógica de negocio de Personas. Delega la paginación
 * en Spring Data (Pageable) y agrega a la respuesta el hostname de la
 * instancia que atendió la petición y el dueño del servicio.
 */
@Service
@Transactional(readOnly = true)
public class PersonaServiceImpl implements PersonaService {

    // Coincide con el VARCHAR(60) de las columnas de la tabla personas.
    private static final int LONGITUD_MAXIMA = 60;

    private final PersonaRepository personaRepository;
    private final HostnameService hostnameService;
    private final DuenoService duenoService;

    public PersonaServiceImpl(PersonaRepository personaRepository, HostnameService hostnameService,
                              DuenoService duenoService) {
        this.personaRepository = personaRepository;
        this.hostnameService = hostnameService;
        this.duenoService = duenoService;
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
        page.setDueno(duenoService.obtenerDueno());
        return page;
    }

    @Override
    public PersonaResponse obtenerPorId(Long id) {
        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new PersonaNoEncontradaException(id));
        return new PersonaResponse(persona, hostnameService.obtenerHostname(), duenoService.obtenerDueno());
    }

    @Override
    @Transactional
    public PersonaResponse actualizar(Long id, PersonaUpdateRequest datos) {
        validar(datos);

        Persona persona = personaRepository.findById(id)
                .orElseThrow(() -> new PersonaNoEncontradaException(id));
        persona.setPrimerNombre(datos.primerNombre());
        persona.setSegundoNombre(datos.segundoNombre());
        persona.setPrimerApellido(datos.primerApellido());
        persona.setSegundoApellido(datos.segundoApellido());

        Persona actualizada = personaRepository.save(persona);
        return new PersonaResponse(actualizada, hostnameService.obtenerHostname(), duenoService.obtenerDueno());
    }

    // Se valida manualmente porque el proyecto no incluye una implementación
    // de Bean Validation (solo jakarta.validation-api), así que @Valid no se aplica.
    private void validar(PersonaUpdateRequest datos) {
        List<String> errores = new ArrayList<>();
        validarObligatorio("primerNombre", datos.primerNombre(), errores);
        validarObligatorio("primerApellido", datos.primerApellido(), errores);
        validarLongitud("primerNombre", datos.primerNombre(), errores);
        validarLongitud("segundoNombre", datos.segundoNombre(), errores);
        validarLongitud("primerApellido", datos.primerApellido(), errores);
        validarLongitud("segundoApellido", datos.segundoApellido(), errores);
        if (!errores.isEmpty()) {
            throw new PersonaInvalidaException(String.join(", ", errores));
        }
    }

    private void validarObligatorio(String campo, String valor, List<String> errores) {
        if (valor == null || valor.isBlank()) {
            errores.add(campo + ": es obligatorio y no puede estar vacío");
        }
    }

    private void validarLongitud(String campo, String valor, List<String> errores) {
        if (valor != null && valor.length() > LONGITUD_MAXIMA) {
            errores.add(campo + ": no puede superar " + LONGITUD_MAXIMA + " caracteres");
        }
    }
}
