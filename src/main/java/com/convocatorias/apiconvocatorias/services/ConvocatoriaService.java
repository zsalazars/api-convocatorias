package com.convocatorias.apiconvocatorias.services;

import com.convocatorias.apiconvocatorias.dto.ConvocatoriaDTO;

import java.util.List;

public interface ConvocatoriaService {
    List<ConvocatoriaDTO> getAllConvocatorias();
    ConvocatoriaDTO getConvocatoriaById(Long id);
    ConvocatoriaDTO createConvocatoria(ConvocatoriaDTO convocatoriaDTO);
    ConvocatoriaDTO updateConvocatoria(Long id, ConvocatoriaDTO convocatoriaDTO);
    boolean existsById(Long id);
}
