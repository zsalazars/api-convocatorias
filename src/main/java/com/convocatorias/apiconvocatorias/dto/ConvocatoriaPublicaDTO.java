package com.convocatorias.apiconvocatorias.dto;

import com.convocatorias.apiconvocatorias.models.Convocatoria;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConvocatoriaPublicaDTO {
    private Long id;
    private String tipoConvocatoria;
    private String tipoRegion;
    private String fechaPublicacion;
    private String fechaEnvioDocumentos;
    private String fechaCalificacionDocumentos;
    private String fechaPublicacionAptos;
    private String fechaHorariosEntrevistas;
    private String fechaEntrevistaPersonal;
    private String fechaPublicacionResultados;
    private String fechaInicioFunciones;
    private Convocatoria.Status estado;
    // Aquí puedes agregar más campos según lo que desees exponer
}
