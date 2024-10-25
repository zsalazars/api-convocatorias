package com.convocatorias.apiconvocatorias.services;

import com.convocatorias.apiconvocatorias.dto.AplicanteDTO;

import java.util.List;

public interface AplicanteService {
    List<AplicanteDTO> getAllAplicantes();
    AplicanteDTO getAplicanteById(Long id);
    AplicanteDTO createAplicante(AplicanteDTO aplicanteDTO);
    AplicanteDTO updateAplicante(Long id, AplicanteDTO aplicanteDTO);
    void deleteAplicante(Long id);
}
