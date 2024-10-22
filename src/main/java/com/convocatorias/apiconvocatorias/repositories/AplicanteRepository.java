package com.convocatorias.apiconvocatorias.repositories;

import com.convocatorias.apiconvocatorias.models.Aplicante;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AplicanteRepository extends JpaRepository<Aplicante, Long> {

}