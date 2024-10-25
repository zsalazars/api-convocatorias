package com.convocatorias.apiconvocatorias.repositories;

import com.convocatorias.apiconvocatorias.models.Solicitud;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SolicitudRepository extends JpaRepository<Solicitud, Long> {

}
