package com.convocatorias.apiconvocatorias.dto;

import com.convocatorias.apiconvocatorias.models.Solicitud; // Importa la clase Solicitud
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SolicitudDTO {
    private Long id;
    private String nombreDocumento;
    private String proveido;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy")
    private LocalDate fechaSolicitud;

    private Solicitud.Status estado;
    private DependenciaDTO dependencia;
    private CargoDTO cargo;
    private LocalDateTime fechaCre;
    private LocalDateTime fechaAct;
}
