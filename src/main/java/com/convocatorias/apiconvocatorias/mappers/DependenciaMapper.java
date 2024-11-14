package com.convocatorias.apiconvocatorias.mappers;

import com.convocatorias.apiconvocatorias.dto.DependenciaDTO;
import com.convocatorias.apiconvocatorias.models.Dependencia;
import org.springframework.stereotype.Component;

@Component
public class DependenciaMapper {
    public DependenciaDTO convertToDTO(Dependencia dependencia) {
        DependenciaDTO dependenciaDTO = new DependenciaDTO();
        dependenciaDTO.setId(dependencia.getId());
        dependenciaDTO.setNombreDependencia(dependencia.getNombreDependencia());
        return dependenciaDTO;
    }

    public Dependencia convertToEntity(DependenciaDTO dependenciaDTO) {
        Dependencia dependencia = new Dependencia();
        dependencia.setNombreDependencia(dependenciaDTO.getNombreDependencia());
        return dependencia;
    }
}
