package com.convocatorias.apiconvocatorias.services;

import com.convocatorias.apiconvocatorias.dto.DependenciaDTO;

import java.util.List;

public interface DependenciaService {
    List<DependenciaDTO> getAllDependencias();
    DependenciaDTO getDependenciaById(Long id);
    DependenciaDTO createDependencia(DependenciaDTO dependenciaDTO);
    DependenciaDTO updateDependencia(Long id, DependenciaDTO dependenciaDTO);
    boolean existsById(Long id);
}
