package com.convocatorias.apiconvocatorias.services.impl;

import com.convocatorias.apiconvocatorias.dto.SolicitudDTO;
import com.convocatorias.apiconvocatorias.mappers.SolicitudMapper;
import com.convocatorias.apiconvocatorias.models.Cargo;
import com.convocatorias.apiconvocatorias.models.Dependencia;
import com.convocatorias.apiconvocatorias.models.Solicitud;
import com.convocatorias.apiconvocatorias.repositories.CargoRepository;
import com.convocatorias.apiconvocatorias.repositories.DependenciaRepository;
import com.convocatorias.apiconvocatorias.repositories.SolicitudRepository;
import com.convocatorias.apiconvocatorias.services.SolicitudService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SolicitudServiceImpl implements SolicitudService {

    private final SolicitudRepository solicitudRepository;
    private final CargoRepository cargoRepository;
    private final DependenciaRepository dependenciaRepository;

    private final SolicitudMapper solicitudMapper;

    @Override
    public List<SolicitudDTO> getAllSolicitudes() {
        return solicitudRepository.findAll().stream()
                .map(solicitudMapper::convertToDTO)
                .toList();
    }

    @Override
    public SolicitudDTO getSolicitudById(Long id) {
        Solicitud solicitud = solicitudRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        return solicitudMapper.convertToDTO(solicitud);
    }

    @Override
    public SolicitudDTO createSolicitud(SolicitudDTO solicitudDTO) {
        // Recuperar la dependencia existente
        Dependencia dependencia = dependenciaRepository.findById(solicitudDTO.getDependencia().getId())
                .orElseThrow(() -> new RuntimeException("Dependencia no encontrada"));

        // Recuperar el cargo existente
        Cargo cargo = cargoRepository.findById(solicitudDTO.getCargo().getId())
                .orElseThrow(() -> new RuntimeException("Cargo no encontrado"));

        // Convertir DTO a entidad
        Solicitud solicitud = solicitudMapper.convertToEntity(solicitudDTO);

        // Asignar la dependencia y el cargo recuperados a la solicitud
        solicitud.setDependencia(dependencia);
        solicitud.setCargo(cargo);

        // Guardar la solicitud
        Solicitud savedSolicitud = solicitudRepository.save(solicitud);
        return solicitudMapper.convertToDTO(savedSolicitud);
    }

    @Override
    public SolicitudDTO updateSolicitud(Long id, SolicitudDTO solicitudDTO) {
        Solicitud solicitud = solicitudMapper.convertToEntity(solicitudDTO);
        solicitud.setId(id);
        Solicitud updatedSolicitud = solicitudRepository.save(solicitud);
        return solicitudMapper.convertToDTO(updatedSolicitud);
    }

    @Override
    public void deleteSolicitud(Long id) {
        solicitudRepository.deleteById(id);
    }

    @Override
    public boolean existsById(Long id) { return solicitudRepository.existsById(id); }

}
