package com.convocatorias.apiconvocatorias.dto;

import com.convocatorias.apiconvocatorias.models.Cargo;
import com.convocatorias.apiconvocatorias.models.Dependencia;
import com.convocatorias.apiconvocatorias.models.Solicitud; // Importa la clase Solicitud
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
    private String documento;
    private Dependencia dependencia;
    private String proveido;
    private Cargo cargo;
    private LocalDate fechaSolicitud;
    private Solicitud.Status estado;
    private LocalDateTime fechaCre;
    private LocalDateTime fechaAct;
}
