package com.convocatorias.apiconvocatorias.repositories;

import com.convocatorias.apiconvocatorias.models.Cargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CargoRepository extends JpaRepository<Cargo, Long> {
    // Aquí puedes agregar métodos adicionales si los necesitas
}