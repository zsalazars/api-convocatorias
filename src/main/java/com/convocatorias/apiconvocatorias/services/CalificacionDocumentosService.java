package com.convocatorias.apiconvocatorias.services;

import com.convocatorias.apiconvocatorias.dto.CalificacionDocumentosDTO;

import java.util.List;

public interface CalificacionDocumentosService {
    List<CalificacionDocumentosDTO> getAllCalificacionDocumentos();
    CalificacionDocumentosDTO getCalificacionDocumentosById(Long id);
    CalificacionDocumentosDTO createCalificacionDocumentos(CalificacionDocumentosDTO calificacionDocumentosDTO);
    CalificacionDocumentosDTO updateCalificacionDocumentos(Long id, CalificacionDocumentosDTO calificacionDocumentosDTO);
    void deleteCalificacionDocumentos(Long id);
    boolean existsById(Long id);
}
