package com.convocatorias.apiconvocatorias.services.impl;

import com.convocatorias.apiconvocatorias.dto.SolicitudDTO;
import com.convocatorias.apiconvocatorias.models.Solicitud;
import com.convocatorias.apiconvocatorias.repositories.SolicitudRepository;
import com.convocatorias.apiconvocatorias.services.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService {

    private final SolicitudRepository solicitudRepository;

    @Override
    public List<SolicitudDTO> getAllSolicitudes() {
        return solicitudRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    public SolicitudDTO getSolicitudId(Long id) {
        Solicitud solicitud = solicitudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        return convertToDTO(solicitud);
    }

    @Override
    public SolicitudDTO createSolicitud(SolicitudDTO solicitudDTO) {
        Solicitud solicitud = convertToEntity(solicitudDTO);
        Solicitud savedSolicitud = solicitudRepository.save(solicitud);
        return convertToDTO(savedSolicitud);
    }

    @Override
    public SolicitudDTO updateSolicitud(Long id, SolicitudDTO solicitudDTO) {
        Solicitud solicitud = convertToEntity(solicitudDTO);
        solicitud.setId(id);
        Solicitud updateSolicitud = solicitudRepository.save(solicitud);
        return convertToDTO(updateSolicitud);
    }

    @Override
    public void deleteSolicitud(Long id) {
        solicitudRepository.deleteById(id);
    }

    private SolicitudDTO convertToDTO(Solicitud solicitud) {
        SolicitudDTO solicitudDTO = new SolicitudDTO();
        solicitudDTO.setId(solicitud.getId());
        solicitudDTO.setDocumento(solicitud.getDocumento());
        solicitudDTO.setProveido(solicitud.getProveedor());
        solicitudDTO.setFechaSolicitud(solicitud.getFechaSolicitud());
        solicitudDTO.setEstado(solicitud.getEstado());
        solicitudDTO.setCargo(solicitud.getCargo());
        solicitudDTO.setDependencia(solicitud.getDependencia());
        return solicitudDTO;
    }

    private Solicitud convertToEntity(SolicitudDTO solicitudDTO) {
        Solicitud solicitud = new Solicitud();
        solicitud.setId(solicitudDTO.getId());
        solicitud.setDocumento(solicitudDTO.getDocumento());
        solicitud.setProveedor(solicitudDTO.getProveido());
        solicitud.setFechaSolicitud(solicitudDTO.getFechaSolicitud());
        solicitud.setEstado(solicitudDTO.getEstado());
        solicitud.setCargo(solicitudDTO.getCargo());
        solicitud.setDependencia(solicitudDTO.getDependencia());
        return solicitud;
    }

}
