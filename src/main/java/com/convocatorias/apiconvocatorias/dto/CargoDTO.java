package com.convocatorias.apiconvocatorias.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CargoDTO {
    private Long id;
    private String nombreCargo;
    private List<String> requisitosEstudios;
    private List<String> requisitosExperiencia;
}
