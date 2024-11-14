package com.convocatorias.apiconvocatorias.dto;

import lombok.*;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CalificacionDocumentosDTO {
    private Long id;
    private Boolean datosGenerales;
    private Boolean titulosCertificados;
    private Boolean reporteSunedu;
    private Boolean cursosEspecializacion;
    private Boolean experienciaLaboral;
    private Boolean declaracionJuradaHorario;
    private Boolean declaracionJuradaParentesco;
    private Boolean declaracionJuradaAntecedentes;
    private Boolean certiadulto;
    private Boolean carnetVacunacion;
    private Boolean voucherPago;
    private String observaciones;
}
