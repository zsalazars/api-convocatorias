package com.convocatorias.apiconvocatorias.services.impl;

import com.convocatorias.apiconvocatorias.dto.ConvocatoriaDTO;
import com.convocatorias.apiconvocatorias.mappers.PostulacionMapper;
import com.convocatorias.apiconvocatorias.mappers.ConvocatoriaMapper;
import com.convocatorias.apiconvocatorias.models.*;
import com.convocatorias.apiconvocatorias.repositories.CargoRepository;
import com.convocatorias.apiconvocatorias.repositories.ConvocatoriaRepository;
import com.convocatorias.apiconvocatorias.repositories.DependenciaRepository;
import com.convocatorias.apiconvocatorias.repositories.SolicitudRepository;
import com.convocatorias.apiconvocatorias.services.ConvocatoriaService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ConvocatoriaServiceImpl implements ConvocatoriaService {
    private final ConvocatoriaRepository convocatoriaRepository;
    private final SolicitudRepository solicitudRepository;
    private final CargoRepository cargoRepository;
    private final DependenciaRepository dependenciaRepository;

    private final ConvocatoriaMapper convocatoriaMapper;
    private final PostulacionMapper postulacionMapper;

    @Override
    public List<ConvocatoriaDTO> getAllConvocatorias() {
        return convocatoriaRepository.findAll().stream()
                .map(convocatoriaMapper::convertToDTO)
                .toList();
    }

    @Override
    public ConvocatoriaDTO getConvocatoriaById(Long id) {
        Convocatoria convocatoria = convocatoriaRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));
        return convocatoriaMapper.convertToDTO(convocatoria);
    }

    @Override
    public ConvocatoriaDTO createConvocatoria(ConvocatoriaDTO convocatoriaDTO) {
        // Recuperar la solicitud existente
        Solicitud solicitud = solicitudRepository.findById(convocatoriaDTO.getSolicitud().getId())
                .orElseThrow(() -> new RuntimeException("Solicitud no encontrada"));

        // Convertir DTO a entidad
        Convocatoria convocatoria = convocatoriaMapper.convertToEntity(convocatoriaDTO);

        // Asignar la solicitud recuperada a la convocatoria
        convocatoria.setSolicitud(solicitud);

        // Guardar la convocatoria
        Convocatoria savedConvocatoria = convocatoriaRepository.save(convocatoria);
        return convocatoriaMapper.convertToDTO(savedConvocatoria);
    }

    @Override
    public ConvocatoriaDTO updateConvocatoria(Long id, ConvocatoriaDTO convocatoriaDTO) {
        Convocatoria convocatoria = convocatoriaMapper.convertToEntity(convocatoriaDTO);
        convocatoria.setId(id);
        Convocatoria updatedConvocatoria = convocatoriaRepository.save(convocatoria);
        return convocatoriaMapper.convertToDTO(updatedConvocatoria);
    }

    @Override
    public boolean existsById(Long id) { return convocatoriaRepository.existsById(id); }
}
