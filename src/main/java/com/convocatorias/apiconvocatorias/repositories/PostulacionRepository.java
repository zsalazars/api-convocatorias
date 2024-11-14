package com.convocatorias.apiconvocatorias.repositories;

import com.convocatorias.apiconvocatorias.models.Postulacion;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PostulacionRepository extends JpaRepository<Postulacion, Long> {
    List<Postulacion> findByConvocatoriaId(Long convocatoriaId);
}