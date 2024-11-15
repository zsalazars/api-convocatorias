package com.convocatorias.apiconvocatorias.dto;

import com.convocatorias.apiconvocatorias.models.Convocatoria;
import com.convocatorias.apiconvocatorias.models.enums.TipoConvocatoria;
import com.convocatorias.apiconvocatorias.models.enums.TipoRegion;
import lombok.*;

import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ConvocatoriaDTO {
    private Long id;
    private int numeroConvocatoria;
    private TipoConvocatoria tipoConvocatoria;
    private TipoRegion tipoRegion;
    private String fechaPublicacion;
    private String fechaEnvioDocumentos;
    private String fechaCalificacionDocumentos;
    private String fechaPublicacionAptos;
    private String fechaHorariosEntrevistas;
    private String fechaEntrevistaPersonal;
    private String fechaPublicacionResultados;
    private String fechaInicioFunciones;
    private Convocatoria.Status estado;
    private SolicitudDTO solicitud;
    private LocalDateTime fechaCre;
    private LocalDateTime fechaAct;
}
