package com.convocatorias.apiconvocatorias.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CalificacionRequisitosDTO {
    private Long id;
    private List<String> requisitosEstudiosCumplidos;
    private List<String> requisitosEstudiosNoCumplidos;
    private List<String> requisitosExperienciaCumplidos;
    private List<String> requisitosExperienciaNoCumplidos;
    private String observaciones;
}
