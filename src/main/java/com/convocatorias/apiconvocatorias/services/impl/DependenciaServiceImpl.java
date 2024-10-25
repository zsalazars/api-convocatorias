package com.convocatorias.apiconvocatorias.services.impl;

import com.convocatorias.apiconvocatorias.dto.DependenciaDTO;
import com.convocatorias.apiconvocatorias.models.Dependencia;
import com.convocatorias.apiconvocatorias.repositories.DependenciaRepository;
import com.convocatorias.apiconvocatorias.services.DependenciaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class DependenciaServiceImpl implements DependenciaService {

    private final DependenciaRepository dependenciaRepository;

    @Override
    public List<DependenciaDTO> getAllDependencias() {
        return dependenciaRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    public DependenciaDTO getDependenciaById(Long id) {
        Dependencia dependencia = dependenciaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Dependencia no encontrada"));
        return convertToDTO(dependencia);
    }

    @Override
    public DependenciaDTO createDependencia(DependenciaDTO dependenciaDTO) {
        Dependencia dependencia = convertToEntity(dependenciaDTO);
        Dependencia savedDependencia = dependenciaRepository.save(dependencia);
        return convertToDTO(savedDependencia);
    }

    @Override
    public DependenciaDTO updateDependencia(Long id, DependenciaDTO dependenciaDTO) {
        Dependencia dependencia = convertToEntity(dependenciaDTO);
        dependencia.setId(id);
        Dependencia updatedDependencia = dependenciaRepository.save(dependencia);
        return convertToDTO(updatedDependencia);
    }

    @Override
    public boolean existsById(Long id) {
        return dependenciaRepository.existsById(id);
    }

    private DependenciaDTO convertToDTO(Dependencia dependencia) {
        DependenciaDTO dependenciaDTO = new DependenciaDTO();
        dependenciaDTO.setId(dependencia.getId());
        dependenciaDTO.setNombreDependencia(dependencia.getNombreDependencia());
        return dependenciaDTO;
    }

    private Dependencia convertToEntity(DependenciaDTO dependenciaDTO) {
        Dependencia dependencia = new Dependencia();
        dependencia.setNombreDependencia(dependenciaDTO.getNombreDependencia());
        return dependencia;
    }
}