package com.convocatorias.apiconvocatorias.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.multipart.MultipartFile;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PostulacionDTO {
    private Long id;
    private String nombres;
    private String apellidoPaterno;
    private String apellidoMaterno;
    private String numeroCelular;
    private String correoElectronico;
    private MultipartFile documento;
    private String documentoRuta;
    private LocalDateTime horaFecha;
    private String observaciones;
    private BigDecimal puntuacion;
    private boolean esApto;
    private ConvocatoriaDTO convocatoria;
    private CalificacionDocumentosDTO calificacionDocumentos;
    private CalificacionRequisitosDTO calificacionRequisitos;
}
