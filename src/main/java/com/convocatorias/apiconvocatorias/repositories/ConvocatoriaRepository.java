package com.convocatorias.apiconvocatorias.repositories;

import com.convocatorias.apiconvocatorias.models.Convocatoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ConvocatoriaRepository extends JpaRepository<Convocatoria, Long> {
}
