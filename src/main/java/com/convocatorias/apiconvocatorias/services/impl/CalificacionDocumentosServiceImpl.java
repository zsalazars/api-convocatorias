package com.convocatorias.apiconvocatorias.services.impl;

import com.convocatorias.apiconvocatorias.dto.CalificacionDocumentosDTO;
import com.convocatorias.apiconvocatorias.mappers.CalificacionDocumentosMapper;
import com.convocatorias.apiconvocatorias.models.CalificacionDocumentos;
import com.convocatorias.apiconvocatorias.repositories.CalificacionDocumentosRepository;
import com.convocatorias.apiconvocatorias.services.CalificacionDocumentosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalificacionDocumentosServiceImpl implements CalificacionDocumentosService {

    private final CalificacionDocumentosRepository calificacionDocumentosRepository;

    private final CalificacionDocumentosMapper calificacionDocumentosMapper;

    @Override
    public List<CalificacionDocumentosDTO> getAllCalificacionDocumentos() {
        return calificacionDocumentosRepository.findAll().stream()
                .map(calificacionDocumentosMapper::convertToDTO)
                .toList();
    }

    @Override
    public CalificacionDocumentosDTO getCalificacionDocumentosById(Long id) {
        CalificacionDocumentos calificacionDocumentos = calificacionDocumentosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calificacion de los documentos no encontrada"));
        return calificacionDocumentosMapper.convertToDTO(calificacionDocumentos);
    }

    @Override
    public CalificacionDocumentosDTO createCalificacionDocumentos(CalificacionDocumentosDTO calificacionDocumentosDTO) {
        CalificacionDocumentos calificacionDocumentos = calificacionDocumentosMapper.convertToEntity(calificacionDocumentosDTO);
        CalificacionDocumentos savedCalificacionDocumentos = calificacionDocumentosRepository.save(calificacionDocumentos);
        return calificacionDocumentosMapper.convertToDTO(savedCalificacionDocumentos);
    }

    @Override
    public CalificacionDocumentosDTO updateCalificacionDocumentos(Long id, CalificacionDocumentosDTO calificacionDocumentosDTO) {
        CalificacionDocumentos calificacionDocumentos = calificacionDocumentosMapper.convertToEntity(calificacionDocumentosDTO);
        calificacionDocumentos.setId(id);
        CalificacionDocumentos updatedCalificacionDocumentos = calificacionDocumentosRepository.save(calificacionDocumentos);
        return calificacionDocumentosMapper.convertToDTO(updatedCalificacionDocumentos);
    }

    @Override
    public void deleteCalificacionDocumentos(Long id) { calificacionDocumentosRepository.deleteById(id); }

    @Override
    public boolean existsById(Long id) { return calificacionDocumentosRepository.existsById(id); }
}