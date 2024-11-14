package com.convocatorias.apiconvocatorias.services;

import com.convocatorias.apiconvocatorias.dto.CalificacionRequisitosDTO;

import java.util.List;

public interface CalificacionRequisitosService {
    List<CalificacionRequisitosDTO> getAllCalificacionRequisitos();
    CalificacionRequisitosDTO getCalificacionRequisitosById(Long id);
    CalificacionRequisitosDTO createCalificacionRequisitos(CalificacionRequisitosDTO calificacionDocumentosDTO);
    CalificacionRequisitosDTO updateCalificacionRequisitos(Long id, CalificacionRequisitosDTO calificacionDocumentosDTO);
    void deleteCalificacionRequisitos(Long id);
    boolean existsById(Long id);
}
