package com.convocatorias.apiconvocatorias.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AplicanteDTO {
    private Long id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String numeroCelular;
    private String correoElectronico;
    private String requerimientos;
    private String observaciones;
    private boolean esApto;
}
