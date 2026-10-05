package co.uptc.ejercicio11.model;

/**
 * DTO con los datos para actualizar una Persona existente. Usa los mismos
 * nombres de campo que devuelve la consulta por id.
 */
public record PersonaUpdateRequest(
        String primerNombre,
        String segundoNombre,
        String primerApellido,
        String segundoApellido
) {
}
