package com.convocatorias.apiconvocatorias.services;

import com.convocatorias.apiconvocatorias.dto.SolicitudDTO;

import java.util.List;

public interface SolicitudService {
    List<SolicitudDTO> getAllSolicitudes();
    SolicitudDTO getSolicitudId(Long id);
    SolicitudDTO createSolicitud(SolicitudDTO solicitudDTO);
    SolicitudDTO updateSolicitud(Long id, SolicitudDTO solicitudDTO);
    void deleteSolicitud(Long id);
}
