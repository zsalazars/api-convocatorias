package com.convocatorias.apiconvocatorias.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DependenciaDTO {
    private long id;
    private String nombreDependencia;
}
