package com.convocatorias.apiconvocatorias.mappers;

import com.convocatorias.apiconvocatorias.dto.CalificacionRequisitosDTO;
import com.convocatorias.apiconvocatorias.models.CalificacionRequisitos;
import org.springframework.stereotype.Component;

@Component
public class CalificacionRequisitosMapper {
    public CalificacionRequisitosDTO convertToDTO(CalificacionRequisitos calificacionRequisitos) {
        CalificacionRequisitosDTO calificacionRequisitosDTO = new CalificacionRequisitosDTO();

        calificacionRequisitosDTO.setId(calificacionRequisitos.getId());
        calificacionRequisitosDTO.setRequisitosEstudiosCumplidos(calificacionRequisitos.getRequisitosEstudiosCumplidos());
        calificacionRequisitosDTO.setRequisitosEstudiosNoCumplidos(calificacionRequisitos.getRequisitosEstudiosNoCumplidos());
        calificacionRequisitosDTO.setRequisitosExperienciaCumplidos(calificacionRequisitos.getRequisitosExperienciaCumplidos());
        calificacionRequisitosDTO.setRequisitosExperienciaNoCumplidos(calificacionRequisitos.getRequisitosExperienciaNoCumplidos());
        calificacionRequisitosDTO.setObservaciones(calificacionRequisitos.getObservaciones());

        return calificacionRequisitosDTO;
    }

    public CalificacionRequisitos convertToEntity(CalificacionRequisitosDTO calificacionRequisitosDTO) {
        CalificacionRequisitos calificacionRequisitos = new CalificacionRequisitos();

        calificacionRequisitos.setId(calificacionRequisitosDTO.getId());
        calificacionRequisitos.setRequisitosEstudiosCumplidos(calificacionRequisitosDTO.getRequisitosEstudiosCumplidos());
        calificacionRequisitos.setRequisitosEstudiosNoCumplidos(calificacionRequisitosDTO.getRequisitosEstudiosNoCumplidos());
        calificacionRequisitos.setRequisitosExperienciaCumplidos(calificacionRequisitosDTO.getRequisitosExperienciaCumplidos());
        calificacionRequisitos.setRequisitosExperienciaNoCumplidos(calificacionRequisitosDTO.getRequisitosExperienciaNoCumplidos());
        calificacionRequisitos.setObservaciones(calificacionRequisitosDTO.getObservaciones());

        return calificacionRequisitos;
    }
}
