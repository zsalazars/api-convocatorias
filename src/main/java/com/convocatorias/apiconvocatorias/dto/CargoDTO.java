package com.convocatorias.apiconvocatorias.dto;

import lombok.Data;

@Data
public class CargoDTO {
    private Long id;
    private String nombreCargo;
    private String requisitosEstudios;
    private String requisitosExperiencia;
}
