package com.convocatorias.apiconvocatorias.services.impl;

import com.convocatorias.apiconvocatorias.dto.CalificacionRequisitosDTO;
import com.convocatorias.apiconvocatorias.mappers.CalificacionRequisitosMapper;
import com.convocatorias.apiconvocatorias.models.CalificacionRequisitos;
import com.convocatorias.apiconvocatorias.repositories.CalificacionRequisitosRepository;
import com.convocatorias.apiconvocatorias.services.CalificacionRequisitosService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CalificacionRequisitosServiceImpl implements CalificacionRequisitosService {

    private final CalificacionRequisitosRepository calificacionRequisitosRepository;

    private final CalificacionRequisitosMapper calificacionRequisitosMapper;

    @Override
    public List<CalificacionRequisitosDTO> getAllCalificacionRequisitos() {
        return calificacionRequisitosRepository.findAll().stream()
                .map(calificacionRequisitosMapper::convertToDTO)
                .toList();
    }

    @Override
    public CalificacionRequisitosDTO getCalificacionRequisitosById(Long id) {
        CalificacionRequisitos calificacionRequisitos = calificacionRequisitosRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Calificacion de los requisitos no encontrada"));
        return calificacionRequisitosMapper.convertToDTO(calificacionRequisitos);
    }

    @Override
    public CalificacionRequisitosDTO createCalificacionRequisitos(CalificacionRequisitosDTO calificacionRequisitosDTO) {
        CalificacionRequisitos calificacionRequisitos = calificacionRequisitosMapper.convertToEntity(calificacionRequisitosDTO);
        CalificacionRequisitos savedCalificacionRequisitos = calificacionRequisitosRepository.save(calificacionRequisitos);
        return calificacionRequisitosMapper.convertToDTO(savedCalificacionRequisitos);
    }

    @Override
    public CalificacionRequisitosDTO updateCalificacionRequisitos(Long id, CalificacionRequisitosDTO calificacionRequisitosDTO) {
        CalificacionRequisitos calificacionRequisitos = calificacionRequisitosMapper.convertToEntity(calificacionRequisitosDTO);
        calificacionRequisitos.setId(id);
        CalificacionRequisitos updatedCalificacionRequisitos = calificacionRequisitosRepository.save(calificacionRequisitos);
        return calificacionRequisitosMapper.convertToDTO(updatedCalificacionRequisitos);
    }

    @Override
    public void deleteCalificacionRequisitos(Long id) { calificacionRequisitosRepository.deleteById(id); }

    @Override
    public boolean existsById(Long id) { return calificacionRequisitosRepository.existsById(id); }
}
