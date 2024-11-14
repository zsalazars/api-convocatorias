package com.convocatorias.apiconvocatorias.models;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Entity // Indica que esta clase es una entidad JPA
@Table(name = "postulacion") // Nombre de la tabla en la base de datos
@Data // Genera automáticamente los getters, setters, toString, hashCode y equals
@NoArgsConstructor // Genera un constructor sin argumentos
public class Postulacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Estrategia para la generación del ID
    private Long id;

    private String nombres;

    @Column(name = "apellido_paterno")
    private String apellidoPaterno;

    @Column(name = "apellido_materno")
    private String apellidoMaterno;

    @Column(name = "numero_celular")
    private String numeroCelular;

    @Column(name = "correo_electronico")
    private String correoElectronico;

    @Column(name = "documento_ruta")
    private String documentoRuta;

    @Column(name = "hora_fecha")
    private LocalDateTime horaFecha;

    private String observaciones;

    private BigDecimal puntuacion;

    @Column(name = "es_apto")
    private boolean esApto;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "calificacion_documento_id", referencedColumnName = "id")
    private CalificacionDocumentos calificacionDocumentos;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "calificacion_requisitos_id", referencedColumnName = "id")
    private CalificacionRequisitos calificacionRequisitos;

    @ManyToOne
    @JoinColumn(name = "convocatoria_id", nullable = false)
    private Convocatoria convocatoria;
}
