package co.uptc.ejercicio11.repository;

import co.uptc.ejercicio11.model.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Acceso a los datos de Persona en PostgreSQL. Spring Data genera la
 * implementación (findAll(Pageable), findById, etc.) en tiempo de ejecución.
 */
@Repository
public interface PersonaRepository extends JpaRepository<Persona, Long> {
}
