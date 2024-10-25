package com.convocatorias.apiconvocatorias.services.impl;

import com.convocatorias.apiconvocatorias.dto.AplicanteDTO;
import com.convocatorias.apiconvocatorias.models.Aplicante;
import com.convocatorias.apiconvocatorias.repositories.AplicanteRepository;
import com.convocatorias.apiconvocatorias.services.AplicanteService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AplicanteServiceImpl implements AplicanteService {

    private AplicanteRepository aplicanteRepository;

    @Override
    public List<AplicanteDTO> getAllAplicantes() {
        return aplicanteRepository.findAll().stream()
                .map(this::convertToDTO)
                .toList();
    }

    @Override
    public AplicanteDTO getAplicanteById(Long id) {
        Aplicante aplicante = aplicanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aplicante no encontrado"));
        return convertToDTO(aplicante);
    }

    @Override
    public AplicanteDTO createAplicante(AplicanteDTO aplicanteDTO) {
        Aplicante aplicante = convertToEntity(aplicanteDTO);
        Aplicante savedAplicante = aplicanteRepository.save(aplicante);
        return convertToDTO(savedAplicante);
    }

    @Override
    public AplicanteDTO updateAplicante(Long id, AplicanteDTO aplicanteDTO) {
        Aplicante aplicante = aplicanteRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Aplicante no encontrado"));

        aplicante.setNombres(aplicanteDTO.getNombres());
        aplicante.setApellidoPaterno(aplicanteDTO.getApellidoPaterno());
        aplicante.setApellidoMaterno(aplicanteDTO.getApellidoMaterno());
        aplicante.setNumeroCelular(aplicanteDTO.getNumeroCelular());
        aplicante.setCorreoElectronico(aplicanteDTO.getCorreoElectronico());
        aplicante.setRequerimientos(aplicanteDTO.getRequerimientos());
        aplicante.setObservaciones(aplicanteDTO.getObservaciones());
        aplicante.setEsApto(aplicanteDTO.isEsApto());

        Aplicante updatedAplicante = aplicanteRepository.save(aplicante);
        return convertToDTO(updatedAplicante);
    }

    @Override
    public void deleteAplicante(Long id) {
        aplicanteRepository.deleteById(id);
    }

    private Aplicante convertToEntity(AplicanteDTO aplicanteDTO) {
        Aplicante aplicante = new Aplicante();
        aplicante.setId(aplicanteDTO.getId());
        aplicante.setNombres(aplicanteDTO.getNombres());
        aplicante.setApellidoPaterno(aplicanteDTO.getApellidoPaterno());
        aplicante.setApellidoMaterno(aplicanteDTO.getApellidoMaterno());
        aplicante.setNumeroCelular(aplicanteDTO.getNumeroCelular());
        aplicante.setCorreoElectronico(aplicanteDTO.getCorreoElectronico());
        aplicante.setRequerimientos(aplicanteDTO.getRequerimientos());
        aplicante.setObservaciones(aplicanteDTO.getObservaciones());
        aplicante.setEsApto(aplicanteDTO.isEsApto());
        return aplicante;
    }

    private AplicanteDTO convertToDTO(Aplicante aplicante) {
        AplicanteDTO aplicanteDTO = new AplicanteDTO();
        aplicanteDTO.setId(aplicante.getId());
        aplicanteDTO.setNombres(aplicante.getNombres());
        aplicanteDTO.setApellidoPaterno(aplicante.getApellidoPaterno());
        aplicanteDTO.setApellidoMaterno(aplicante.getApellidoMaterno());
        aplicanteDTO.setNumeroCelular(aplicante.getNumeroCelular());
        aplicanteDTO.setCorreoElectronico(aplicante.getCorreoElectronico());
        aplicanteDTO.setRequerimientos(aplicante.getRequerimientos());
        aplicanteDTO.setObservaciones(aplicante.getObservaciones());
        aplicanteDTO.setEsApto(aplicante.isEsApto());
        return aplicanteDTO;
    }
}
